import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import gobley.gradle.GobleyHost
import gobley.gradle.Variant
import gobley.gradle.cargo.dsl.jvm
import gobley.gradle.cargo.tasks.CargoBuildTask
import gobley.gradle.cargo.tasks.FindDynamicLibrariesTask
import gobley.gradle.cargo.tasks.RustUpTargetAddTask
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.File

fun rustLibraryName(triple: String): String = when {
    triple.contains("windows") -> "composewebview_wry.dll"
    triple.contains("darwin") || triple.contains("apple") -> "libcomposewebview_wry.dylib"
    else -> "libcomposewebview_wry.so"
}

fun Project.prebuiltRustLibrary(triple: String): File =
    layout.projectDirectory.dir("target/$triple/release").file(rustLibraryName(triple)).asFile

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinAtomicfu)
    alias(libs.plugins.gobleyCargo)
    alias(libs.plugins.gobleyRust)
    alias(libs.plugins.mavenPublish)
}

cargo {
    jvmVariant.set(Variant.Release)
    builds.jvm {
        // Only embed for the current host platform; other platforms are packed as resources.
        embedRustLibrary = GobleyHost.current.rustTarget == rustTarget
    }
}

rust {
    val userHome = System.getProperty("user.home")
    val cargoBin = file("$userHome/.cargo/bin")
    val rustupToolchainBin = file(
        "$userHome/.rustup/toolchains/stable-${GobleyHost.current.rustTarget.rustTriple}/bin",
    )
    when {
        cargoBin.resolve("rustc").exists() -> toolchainDirectory.set(cargoBin)
        rustupToolchainBin.resolve("rustc").exists() -> toolchainDirectory.set(rustupToolchainBin)
    }
}

// UniFFI bindings are now vendored as pure-FFM Java under src/main/java/uniffi/ (generated
// by IronCoreLabs/uniffi-bindgen-java), replacing the gobleyUniffi JNA codegen so the library
// works in GraalVM native-image. Regenerate with:
//   uniffi-bindgen-java generate --out-dir src/main/java target/<triple>/release/<cdylib>

kotlin {
    jvmToolchain(22)
}

sourceSets {
    main {
        resources.srcDir("src/jvmMain/resources")
    }
}

dependencies {
    implementation(libs.skiko.awt)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
    compilerOptions {
        // Toolchain is 22 so the vendored FFM bindings see java.lang.foreign, but emit 21
        // bytecode (no --release, so foreign stays visible) — keeps the artifact resolvable by
        // JVM-21 consumers like SoundBound's desktop classpath; it runs on a JDK 22+ runtime.
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

// Prebuilt-library skip — config-cache SAFE. The prebuilt path is resolved at CONFIGURATION time
// (Project.prebuiltRustLibrary) and only a plain Boolean/File is captured into the onlyIf closure;
// `project`/`Task.project` is NEVER touched at execution time (doing so throws under Gradle's
// configuration cache — gobley's RustUpTargetAddTask hit exactly that). When a prebuilt cdylib
// exists for a triple, the cargo build AND the rustup-target-add are skipped for it — INCLUDING the
// host target (we deliberately do NOT special-case the host: a committed/cached dylib should skip
// the slow Rust build everywhere so consumers like SoundBound keep configuration-cache + Gradle
// build-cache hits). Delete target/<triple>/release/<lib> (or run a clean) to force a real rebuild.
tasks.withType<CargoBuildTask>().configureEach {
    val prebuiltExists = target.orNull?.let { project.prebuiltRustLibrary(it.rustTriple).exists() } ?: false
    onlyIf { !prebuiltExists }
}

tasks.withType<FindDynamicLibrariesTask>().configureEach {
    val rt = rustTarget.orNull ?: return@configureEach
    val prebuiltLib = project.prebuiltRustLibrary(rt.rustTriple)
    if (prebuiltLib.exists()) {
        searchPaths.set(listOf(prebuiltLib.parentFile))
    }
}

tasks.withType<RustUpTargetAddTask>().configureEach {
    val prebuiltExists = rustTarget.orNull?.let { project.prebuiltRustLibrary(it.rustTriple).exists() } ?: false
    onlyIf { !prebuiltExists }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
    // Compile with JDK 22 (FFM visible) but emit 21 bytecode so JVM-21 consumers can resolve it.
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

mavenPublishing {
    configure(JavaLibrary(javadocJar = JavadocJar.Empty(), sourcesJar = true))
    publishToMavenCentral()
    if (project.findProperty("signingInMemoryKey") != null) {
        signAllPublications()
    }
    coordinates(artifactId = "wrywebview")
    pom {
        name.set("WryWebView")
        description.set("Native WebView bindings for JVM using Wry (Rust)")
    }
}

// Publish native runtime JARs as additional artifacts
afterEvaluate {
    publishing {
        publications.withType<MavenPublication>().configureEach {
            if (name == "maven") {
                // Add native runtime JARs for each platform
                val nativeJars = layout.buildDirectory.dir("libs").get().asFile.listFiles()
                    ?.filter { it.name.startsWith("wrywebview-") && it.name.endsWith(".jar") && !it.name.contains("sources") && !it.name.contains("javadoc") }
                    ?: emptyList()

                nativeJars.forEach { jar ->
                    val classifier = jar.name.removePrefix("wrywebview-").removeSuffix(".jar")
                    artifact(jar) {
                        this.classifier = classifier
                    }
                }
            }
        }
    }
}
