# GraalVM native-image reachability metadata

`reachability-metadata.json` here registers the FFM (Foreign Function & Memory) downcalls and
upcalls the vendored UniFFI bindings make, so GraalVM native-image accepts them. It is picked up
automatically from `META-INF/native-image/<group>/<artifact>/`.

This is a STARTER set captured by the native-image tracing agent over a minimal cookie/getter
probe. It does NOT yet cover every native call the full webview exercises (createWebview, loadUrl,
evaluateJavascript callbacks, etc.). A consumer producing a native image must run the tracing agent
over a real create→navigate→callback→destroy run and merge the result:

    java -agentlib:native-image-agent=config-merge-dir=<this-dir> -cp ... <app exercising the webview>

Required native-image flags (consumer side): `--enable-native-access=ALL-UNNAMED`,
`-H:+UnlockExperimentalVMOptions -H:+ForeignAPISupport`,
`--initialize-at-run-time=uniffi.composewebview_wry`.
