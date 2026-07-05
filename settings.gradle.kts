rootProject.name = "composewebview"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":demo")
include(":demo-shared")
// demo-android applies com.android.application, which resolves sdk.dir at CONFIGURATION time.
// Consumers that only need :webview-compose (e.g. SoundBound's Docker linux native-image builders)
// have no Android SDK — an unconditional include breaks their configuration phase. Gate it.
if (System.getenv("ANDROID_HOME") != null || rootDir.resolve("local.properties").readTextOrNull()?.contains("sdk.dir") == true) {
    include(":demo-android")
}
include(":demo-wasmJs")
include(":wrywebview")
include(":webview-compose")

fun java.io.File.readTextOrNull(): String? = if (isFile) readText() else null
