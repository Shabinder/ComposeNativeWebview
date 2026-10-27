package uniffi.composewebview_wry;


// FFM-based library binding. Each FFI function gets a MethodHandle and a wrapper method.
final class UniffiLib {
    private static final java.lang.foreign.Linker LINKER = java.lang.foreign.Linker.nativeLinker();
    private static final java.lang.foreign.SymbolLookup SYMBOLS;

    

    static {
        SYMBOLS = NamespaceLibrary.loadLibrary();
    }

    private static java.lang.invoke.MethodHandle findDowncallHandle(String name, java.lang.foreign.FunctionDescriptor descriptor) {
        return SYMBOLS.find(name)
            .map(s -> LINKER.downcallHandle(s, descriptor))
            .orElseThrow(() -> new RuntimeException("Missing FFI symbol: " + name));
    }

    // uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback = findDowncallHandle("uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback(java.lang.foreign.MemorySegment vtable) {
        try {
            MH_uniffi_composewebview_wry_fn_init_callback_vtable_javascriptcallback.invokeExact(vtable);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger = findDowncallHandle("uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger(java.lang.foreign.MemorySegment vtable) {
        try {
            MH_uniffi_composewebview_wry_fn_init_callback_vtable_nativelogger.invokeExact(vtable);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler = findDowncallHandle("uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler(java.lang.foreign.MemorySegment vtable) {
        try {
            MH_uniffi_composewebview_wry_fn_init_callback_vtable_navigationhandler.invokeExact(vtable);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_can_go_back
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_can_go_back = findDowncallHandle("uniffi_composewebview_wry_fn_func_can_go_back", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static byte uniffi_composewebview_wry_fn_func_can_go_back(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (byte) MH_uniffi_composewebview_wry_fn_func_can_go_back.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_can_go_forward
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_can_go_forward = findDowncallHandle("uniffi_composewebview_wry_fn_func_can_go_forward", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static byte uniffi_composewebview_wry_fn_func_can_go_forward(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (byte) MH_uniffi_composewebview_wry_fn_func_can_go_forward.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_clear_all_cookies
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_clear_all_cookies = findDowncallHandle("uniffi_composewebview_wry_fn_func_clear_all_cookies", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_clear_all_cookies(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_clear_all_cookies.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_clear_cookies_for_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_clear_cookies_for_url = findDowncallHandle("uniffi_composewebview_wry_fn_func_clear_cookies_for_url", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_clear_cookies_for_url(long id, java.lang.foreign.MemorySegment url, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_clear_cookies_for_url.invokeExact(id, url, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_close_dev_tools
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_close_dev_tools = findDowncallHandle("uniffi_composewebview_wry_fn_func_close_dev_tools", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_close_dev_tools(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_close_dev_tools.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_create_webview
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_create_webview = findDowncallHandle("uniffi_composewebview_wry_fn_func_create_webview", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_INT, RustBuffer.LAYOUT, RustBuffer.LAYOUT, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, RustBuffer.LAYOUT, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_BYTE, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static long uniffi_composewebview_wry_fn_func_create_webview(long parentHandle, int width, int height, java.lang.foreign.MemorySegment url, java.lang.foreign.MemorySegment userAgent, java.lang.foreign.MemorySegment dataDirectory, byte zoom, byte transparent, java.lang.foreign.MemorySegment backgroundColor, java.lang.foreign.MemorySegment initScript, byte clipboard, byte devTools, byte navigationGestures, byte incognito, byte autoplay, byte focused, java.lang.foreign.MemorySegment navHandler, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (long) MH_uniffi_composewebview_wry_fn_func_create_webview.invokeExact(parentHandle, width, height, url, userAgent, dataDirectory, zoom, transparent, backgroundColor, initScript, clipboard, devTools, navigationGestures, incognito, autoplay, focused, navHandler, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_destroy_webview
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_destroy_webview = findDowncallHandle("uniffi_composewebview_wry_fn_func_destroy_webview", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_destroy_webview(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_destroy_webview.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_drain_ipc_messages
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_drain_ipc_messages = findDowncallHandle("uniffi_composewebview_wry_fn_func_drain_ipc_messages", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment uniffi_composewebview_wry_fn_func_drain_ipc_messages(java.lang.foreign.SegmentAllocator _allocator, long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_uniffi_composewebview_wry_fn_func_drain_ipc_messages.invokeExact(_allocator, id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_evaluate_javascript
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_evaluate_javascript = findDowncallHandle("uniffi_composewebview_wry_fn_func_evaluate_javascript", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_evaluate_javascript(long id, java.lang.foreign.MemorySegment script, long callback, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_evaluate_javascript.invokeExact(id, script, callback, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_focus
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_focus = findDowncallHandle("uniffi_composewebview_wry_fn_func_focus", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_focus(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_focus.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_get_cookies
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_get_cookies = findDowncallHandle("uniffi_composewebview_wry_fn_func_get_cookies", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment uniffi_composewebview_wry_fn_func_get_cookies(java.lang.foreign.SegmentAllocator _allocator, long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_uniffi_composewebview_wry_fn_func_get_cookies.invokeExact(_allocator, id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_get_cookies_for_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_get_cookies_for_url = findDowncallHandle("uniffi_composewebview_wry_fn_func_get_cookies_for_url", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment uniffi_composewebview_wry_fn_func_get_cookies_for_url(java.lang.foreign.SegmentAllocator _allocator, long id, java.lang.foreign.MemorySegment url, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_uniffi_composewebview_wry_fn_func_get_cookies_for_url.invokeExact(_allocator, id, url, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_get_title
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_get_title = findDowncallHandle("uniffi_composewebview_wry_fn_func_get_title", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment uniffi_composewebview_wry_fn_func_get_title(java.lang.foreign.SegmentAllocator _allocator, long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_uniffi_composewebview_wry_fn_func_get_title.invokeExact(_allocator, id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_get_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_get_url = findDowncallHandle("uniffi_composewebview_wry_fn_func_get_url", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment uniffi_composewebview_wry_fn_func_get_url(java.lang.foreign.SegmentAllocator _allocator, long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_uniffi_composewebview_wry_fn_func_get_url.invokeExact(_allocator, id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_go_back
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_go_back = findDowncallHandle("uniffi_composewebview_wry_fn_func_go_back", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_go_back(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_go_back.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_go_forward
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_go_forward = findDowncallHandle("uniffi_composewebview_wry_fn_func_go_forward", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_go_forward(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_go_forward.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_is_loading
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_is_loading = findDowncallHandle("uniffi_composewebview_wry_fn_func_is_loading", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static byte uniffi_composewebview_wry_fn_func_is_loading(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (byte) MH_uniffi_composewebview_wry_fn_func_is_loading.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_load_html
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_load_html = findDowncallHandle("uniffi_composewebview_wry_fn_func_load_html", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_load_html(long id, java.lang.foreign.MemorySegment html, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_load_html.invokeExact(id, html, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_load_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_load_url = findDowncallHandle("uniffi_composewebview_wry_fn_func_load_url", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_load_url(long id, java.lang.foreign.MemorySegment url, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_load_url.invokeExact(id, url, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_load_url_with_headers
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_load_url_with_headers = findDowncallHandle("uniffi_composewebview_wry_fn_func_load_url_with_headers", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_load_url_with_headers(long id, java.lang.foreign.MemorySegment url, java.lang.foreign.MemorySegment headers, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_load_url_with_headers.invokeExact(id, url, headers, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_open_dev_tools
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_open_dev_tools = findDowncallHandle("uniffi_composewebview_wry_fn_func_open_dev_tools", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_open_dev_tools(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_open_dev_tools.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_pump_gtk_events
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_pump_gtk_events = findDowncallHandle("uniffi_composewebview_wry_fn_func_pump_gtk_events", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_pump_gtk_events(java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_pump_gtk_events.invokeExact(uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_pump_windows_events
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_pump_windows_events = findDowncallHandle("uniffi_composewebview_wry_fn_func_pump_windows_events", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_pump_windows_events(java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_pump_windows_events.invokeExact(uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_reload
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_reload = findDowncallHandle("uniffi_composewebview_wry_fn_func_reload", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_reload(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_reload.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_set_bounds
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_set_bounds = findDowncallHandle("uniffi_composewebview_wry_fn_func_set_bounds", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_set_bounds(long id, int x, int y, int width, int height, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_set_bounds.invokeExact(id, x, y, width, height, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_set_cookie
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_set_cookie = findDowncallHandle("uniffi_composewebview_wry_fn_func_set_cookie", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_set_cookie(long id, java.lang.foreign.MemorySegment cookie, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_set_cookie.invokeExact(id, cookie, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_set_log_enabled
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_set_log_enabled = findDowncallHandle("uniffi_composewebview_wry_fn_func_set_log_enabled", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_set_log_enabled(byte enabled, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_set_log_enabled.invokeExact(enabled, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_set_native_logger
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_set_native_logger = findDowncallHandle("uniffi_composewebview_wry_fn_func_set_native_logger", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_set_native_logger(long logger, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_set_native_logger.invokeExact(logger, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_fn_func_stop_loading
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_fn_func_stop_loading = findDowncallHandle("uniffi_composewebview_wry_fn_func_stop_loading", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void uniffi_composewebview_wry_fn_func_stop_loading(long id, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_uniffi_composewebview_wry_fn_func_stop_loading.invokeExact(id, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rustbuffer_alloc
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rustbuffer_alloc = findDowncallHandle("ffi_composewebview_wry_rustbuffer_alloc", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment ffi_composewebview_wry_rustbuffer_alloc(java.lang.foreign.SegmentAllocator _allocator, long size, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_ffi_composewebview_wry_rustbuffer_alloc.invokeExact(_allocator, size, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rustbuffer_from_bytes
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rustbuffer_from_bytes = findDowncallHandle("ffi_composewebview_wry_rustbuffer_from_bytes", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, ForeignBytes.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment ffi_composewebview_wry_rustbuffer_from_bytes(java.lang.foreign.SegmentAllocator _allocator, java.lang.foreign.MemorySegment bytes, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_ffi_composewebview_wry_rustbuffer_from_bytes.invokeExact(_allocator, bytes, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rustbuffer_free
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rustbuffer_free = findDowncallHandle("ffi_composewebview_wry_rustbuffer_free", java.lang.foreign.FunctionDescriptor.ofVoid(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.ADDRESS));

    static void ffi_composewebview_wry_rustbuffer_free(java.lang.foreign.MemorySegment buf, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_ffi_composewebview_wry_rustbuffer_free.invokeExact(buf, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rustbuffer_reserve
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rustbuffer_reserve = findDowncallHandle("ffi_composewebview_wry_rustbuffer_reserve", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment ffi_composewebview_wry_rustbuffer_reserve(java.lang.foreign.SegmentAllocator _allocator, java.lang.foreign.MemorySegment buf, long additional, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_ffi_composewebview_wry_rustbuffer_reserve.invokeExact(_allocator, buf, additional, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_u8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_u8 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_u8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_u8(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_u8.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_u8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_u8 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_u8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_u8(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_u8.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_u8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_u8 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_u8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_u8(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_u8.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_u8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_u8 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_u8", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static byte ffi_composewebview_wry_rust_future_complete_u8(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (byte) MH_ffi_composewebview_wry_rust_future_complete_u8.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_i8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_i8 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_i8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_i8(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_i8.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_i8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_i8 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_i8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_i8(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_i8.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_i8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_i8 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_i8", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_i8(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_i8.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_i8
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_i8 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_i8", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_BYTE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static byte ffi_composewebview_wry_rust_future_complete_i8(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (byte) MH_ffi_composewebview_wry_rust_future_complete_i8.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_u16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_u16 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_u16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_u16(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_u16.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_u16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_u16 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_u16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_u16(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_u16.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_u16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_u16 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_u16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_u16(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_u16.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_u16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_u16 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_u16", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static short ffi_composewebview_wry_rust_future_complete_u16(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (short) MH_ffi_composewebview_wry_rust_future_complete_u16.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_i16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_i16 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_i16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_i16(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_i16.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_i16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_i16 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_i16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_i16(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_i16.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_i16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_i16 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_i16", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_i16(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_i16.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_i16
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_i16 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_i16", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static short ffi_composewebview_wry_rust_future_complete_i16(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (short) MH_ffi_composewebview_wry_rust_future_complete_i16.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_u32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_u32 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_u32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_u32(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_u32.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_u32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_u32 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_u32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_u32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_u32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_u32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_u32 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_u32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_u32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_u32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_u32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_u32 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_u32", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static int ffi_composewebview_wry_rust_future_complete_u32(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (int) MH_ffi_composewebview_wry_rust_future_complete_u32.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_i32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_i32 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_i32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_i32(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_i32.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_i32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_i32 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_i32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_i32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_i32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_i32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_i32 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_i32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_i32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_i32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_i32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_i32 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_i32", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_INT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static int ffi_composewebview_wry_rust_future_complete_i32(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (int) MH_ffi_composewebview_wry_rust_future_complete_i32.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_u64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_u64 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_u64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_u64(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_u64.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_u64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_u64 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_u64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_u64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_u64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_u64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_u64 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_u64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_u64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_u64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_u64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_u64 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_u64", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static long ffi_composewebview_wry_rust_future_complete_u64(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (long) MH_ffi_composewebview_wry_rust_future_complete_u64.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_i64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_i64 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_i64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_i64(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_i64.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_i64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_i64 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_i64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_i64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_i64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_i64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_i64 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_i64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_i64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_i64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_i64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_i64 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_i64", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static long ffi_composewebview_wry_rust_future_complete_i64(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (long) MH_ffi_composewebview_wry_rust_future_complete_i64.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_f32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_f32 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_f32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_f32(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_f32.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_f32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_f32 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_f32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_f32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_f32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_f32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_f32 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_f32", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_f32(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_f32.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_f32
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_f32 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_f32", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_FLOAT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static float ffi_composewebview_wry_rust_future_complete_f32(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (float) MH_ffi_composewebview_wry_rust_future_complete_f32.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_f64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_f64 = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_f64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_f64(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_f64.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_f64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_f64 = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_f64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_f64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_f64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_f64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_f64 = findDowncallHandle("ffi_composewebview_wry_rust_future_free_f64", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_f64(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_f64.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_f64
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_f64 = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_f64", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_DOUBLE, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static double ffi_composewebview_wry_rust_future_complete_f64(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (double) MH_ffi_composewebview_wry_rust_future_complete_f64.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_rust_buffer
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_rust_buffer = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_rust_buffer", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_rust_buffer(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_rust_buffer.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_rust_buffer
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_rust_buffer = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_rust_buffer", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_rust_buffer(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_rust_buffer.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_rust_buffer
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_rust_buffer = findDowncallHandle("ffi_composewebview_wry_rust_future_free_rust_buffer", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_rust_buffer(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_rust_buffer.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_rust_buffer
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_rust_buffer = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_rust_buffer", java.lang.foreign.FunctionDescriptor.of(RustBuffer.LAYOUT, java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static java.lang.foreign.MemorySegment ffi_composewebview_wry_rust_future_complete_rust_buffer(java.lang.foreign.SegmentAllocator _allocator, long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            return (java.lang.foreign.MemorySegment) MH_ffi_composewebview_wry_rust_future_complete_rust_buffer.invokeExact(_allocator, handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_poll_void
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_poll_void = findDowncallHandle("ffi_composewebview_wry_rust_future_poll_void", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS, java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_poll_void(long handle, java.lang.foreign.MemorySegment callback, long callbackData) {
        try {
            MH_ffi_composewebview_wry_rust_future_poll_void.invokeExact(handle, callback, callbackData);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_cancel_void
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_cancel_void = findDowncallHandle("ffi_composewebview_wry_rust_future_cancel_void", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_cancel_void(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_cancel_void.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_free_void
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_free_void = findDowncallHandle("ffi_composewebview_wry_rust_future_free_void", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG));

    static void ffi_composewebview_wry_rust_future_free_void(long handle) {
        try {
            MH_ffi_composewebview_wry_rust_future_free_void.invokeExact(handle);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_rust_future_complete_void
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_rust_future_complete_void = findDowncallHandle("ffi_composewebview_wry_rust_future_complete_void", java.lang.foreign.FunctionDescriptor.ofVoid(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.ADDRESS));

    static void ffi_composewebview_wry_rust_future_complete_void(long handle, java.lang.foreign.MemorySegment uniffiOutErr) {
        try {
            MH_ffi_composewebview_wry_rust_future_complete_void.invokeExact(handle, uniffiOutErr);
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_can_go_back
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_can_go_back = findDowncallHandle("uniffi_composewebview_wry_checksum_func_can_go_back", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_can_go_back() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_can_go_back.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_can_go_forward
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_can_go_forward = findDowncallHandle("uniffi_composewebview_wry_checksum_func_can_go_forward", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_can_go_forward() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_can_go_forward.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_clear_all_cookies
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_clear_all_cookies = findDowncallHandle("uniffi_composewebview_wry_checksum_func_clear_all_cookies", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_clear_all_cookies() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_clear_all_cookies.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_clear_cookies_for_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_clear_cookies_for_url = findDowncallHandle("uniffi_composewebview_wry_checksum_func_clear_cookies_for_url", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_clear_cookies_for_url() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_clear_cookies_for_url.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_close_dev_tools
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_close_dev_tools = findDowncallHandle("uniffi_composewebview_wry_checksum_func_close_dev_tools", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_close_dev_tools() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_close_dev_tools.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_create_webview
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_create_webview = findDowncallHandle("uniffi_composewebview_wry_checksum_func_create_webview", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_create_webview() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_create_webview.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_destroy_webview
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_destroy_webview = findDowncallHandle("uniffi_composewebview_wry_checksum_func_destroy_webview", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_destroy_webview() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_destroy_webview.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_drain_ipc_messages
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_drain_ipc_messages = findDowncallHandle("uniffi_composewebview_wry_checksum_func_drain_ipc_messages", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_drain_ipc_messages() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_drain_ipc_messages.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_evaluate_javascript
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_evaluate_javascript = findDowncallHandle("uniffi_composewebview_wry_checksum_func_evaluate_javascript", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_evaluate_javascript() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_evaluate_javascript.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_focus
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_focus = findDowncallHandle("uniffi_composewebview_wry_checksum_func_focus", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_focus() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_focus.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_get_cookies
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_get_cookies = findDowncallHandle("uniffi_composewebview_wry_checksum_func_get_cookies", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_get_cookies() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_get_cookies.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_get_cookies_for_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_get_cookies_for_url = findDowncallHandle("uniffi_composewebview_wry_checksum_func_get_cookies_for_url", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_get_cookies_for_url() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_get_cookies_for_url.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_get_title
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_get_title = findDowncallHandle("uniffi_composewebview_wry_checksum_func_get_title", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_get_title() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_get_title.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_get_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_get_url = findDowncallHandle("uniffi_composewebview_wry_checksum_func_get_url", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_get_url() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_get_url.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_go_back
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_go_back = findDowncallHandle("uniffi_composewebview_wry_checksum_func_go_back", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_go_back() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_go_back.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_go_forward
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_go_forward = findDowncallHandle("uniffi_composewebview_wry_checksum_func_go_forward", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_go_forward() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_go_forward.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_is_loading
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_is_loading = findDowncallHandle("uniffi_composewebview_wry_checksum_func_is_loading", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_is_loading() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_is_loading.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_load_html
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_load_html = findDowncallHandle("uniffi_composewebview_wry_checksum_func_load_html", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_load_html() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_load_html.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_load_url
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_load_url = findDowncallHandle("uniffi_composewebview_wry_checksum_func_load_url", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_load_url() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_load_url.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_load_url_with_headers
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_load_url_with_headers = findDowncallHandle("uniffi_composewebview_wry_checksum_func_load_url_with_headers", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_load_url_with_headers() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_load_url_with_headers.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_open_dev_tools
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_open_dev_tools = findDowncallHandle("uniffi_composewebview_wry_checksum_func_open_dev_tools", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_open_dev_tools() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_open_dev_tools.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_pump_gtk_events
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_pump_gtk_events = findDowncallHandle("uniffi_composewebview_wry_checksum_func_pump_gtk_events", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_pump_gtk_events() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_pump_gtk_events.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_pump_windows_events
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_pump_windows_events = findDowncallHandle("uniffi_composewebview_wry_checksum_func_pump_windows_events", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_pump_windows_events() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_pump_windows_events.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_reload
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_reload = findDowncallHandle("uniffi_composewebview_wry_checksum_func_reload", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_reload() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_reload.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_set_bounds
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_set_bounds = findDowncallHandle("uniffi_composewebview_wry_checksum_func_set_bounds", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_set_bounds() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_set_bounds.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_set_cookie
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_set_cookie = findDowncallHandle("uniffi_composewebview_wry_checksum_func_set_cookie", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_set_cookie() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_set_cookie.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_set_log_enabled
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_set_log_enabled = findDowncallHandle("uniffi_composewebview_wry_checksum_func_set_log_enabled", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_set_log_enabled() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_set_log_enabled.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_set_native_logger
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_set_native_logger = findDowncallHandle("uniffi_composewebview_wry_checksum_func_set_native_logger", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_set_native_logger() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_set_native_logger.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_func_stop_loading
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_func_stop_loading = findDowncallHandle("uniffi_composewebview_wry_checksum_func_stop_loading", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_func_stop_loading() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_func_stop_loading.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_method_javascriptcallback_on_result
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_method_javascriptcallback_on_result = findDowncallHandle("uniffi_composewebview_wry_checksum_method_javascriptcallback_on_result", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_method_javascriptcallback_on_result() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_method_javascriptcallback_on_result.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_method_nativelogger_handle_log
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_method_nativelogger_handle_log = findDowncallHandle("uniffi_composewebview_wry_checksum_method_nativelogger_handle_log", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_method_nativelogger_handle_log() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_method_nativelogger_handle_log.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // uniffi_composewebview_wry_checksum_method_navigationhandler_handle_navigation
    private static final java.lang.invoke.MethodHandle MH_uniffi_composewebview_wry_checksum_method_navigationhandler_handle_navigation = findDowncallHandle("uniffi_composewebview_wry_checksum_method_navigationhandler_handle_navigation", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_SHORT));

    static short uniffi_composewebview_wry_checksum_method_navigationhandler_handle_navigation() {
        try {
            return (short) MH_uniffi_composewebview_wry_checksum_method_navigationhandler_handle_navigation.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    // ffi_composewebview_wry_uniffi_contract_version
    private static final java.lang.invoke.MethodHandle MH_ffi_composewebview_wry_uniffi_contract_version = findDowncallHandle("ffi_composewebview_wry_uniffi_contract_version", java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_INT));

    static int ffi_composewebview_wry_uniffi_contract_version() {
        try {
            return (int) MH_ffi_composewebview_wry_uniffi_contract_version.invokeExact();
        } catch (Throwable _ex) { throw new AssertionError("invokeExact failed", _ex); }
    }

    

    // Integrity checks and initialization must happen after all MethodHandle fields
    // are initialized (static fields are initialized in textual order in Java).
    static {
        NamespaceLibrary.uniffiCheckContractApiVersion();
        NamespaceLibrary.uniffiCheckApiChecksums();
        
        UniffiCallbackInterfaceJavaScriptCallback.INSTANCE.register();
        UniffiCallbackInterfaceNativeLogger.INSTANCE.register();
        UniffiCallbackInterfaceNavigationHandler.INSTANCE.register();
        }
}

