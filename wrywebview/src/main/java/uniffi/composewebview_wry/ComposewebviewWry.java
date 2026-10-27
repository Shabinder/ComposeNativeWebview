package uniffi.composewebview_wry;


import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
public class ComposewebviewWry {
  public static boolean canGoBack(long id) throws WebViewException {
            try {
                return FfiConverterBoolean.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_can_go_back(
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static boolean canGoForward(long id) throws WebViewException {
            try {
                return FfiConverterBoolean.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_can_go_forward(
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void clearAllCookies(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_clear_all_cookies(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void clearCookiesForUrl(long id, java.lang.String url) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_clear_cookies_for_url(
            id, FfiConverterString.INSTANCE.lower(url), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void closeDevTools(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_close_dev_tools(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static long createWebview(long parentHandle, int width, int height, java.lang.String url, java.lang.String userAgent, java.lang.String dataDirectory, boolean zoom, boolean transparent, Rgba backgroundColor, java.lang.String initScript, boolean clipboard, boolean devTools, boolean navigationGestures, boolean incognito, boolean autoplay, boolean focused, NavigationHandler navHandler) throws WebViewException {
            try {
                return 
    UniffiHelpers.uniffiRustCallWithErrorLong(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_create_webview(
            parentHandle, width, height, FfiConverterString.INSTANCE.lower(url), FfiConverterOptionalString.INSTANCE.lower(userAgent), FfiConverterOptionalString.INSTANCE.lower(dataDirectory), FfiConverterBoolean.INSTANCE.lower(zoom), FfiConverterBoolean.INSTANCE.lower(transparent), FfiConverterTypeRgba.INSTANCE.lower(backgroundColor), FfiConverterOptionalString.INSTANCE.lower(initScript), FfiConverterBoolean.INSTANCE.lower(clipboard), FfiConverterBoolean.INSTANCE.lower(devTools), FfiConverterBoolean.INSTANCE.lower(navigationGestures), FfiConverterBoolean.INSTANCE.lower(incognito), FfiConverterBoolean.INSTANCE.lower(autoplay), FfiConverterBoolean.INSTANCE.lower(focused), FfiConverterOptionalTypeNavigationHandler.INSTANCE.lower(navHandler), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void destroyWebview(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_destroy_webview(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static java.util.List<java.lang.String> drainIpcMessages(long id) throws WebViewException {
            try {
                return FfiConverterSequenceString.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_drain_ipc_messages(_allocator, 
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void evaluateJavascript(long id, java.lang.String script, JavaScriptCallback callback) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_evaluate_javascript(
            id, FfiConverterString.INSTANCE.lower(script), FfiConverterTypeJavaScriptCallback.INSTANCE.lower(callback), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void focus(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_focus(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static java.util.List<WebViewCookie> getCookies(long id) throws WebViewException {
            try {
                return FfiConverterSequenceTypeWebViewCookie.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_get_cookies(_allocator, 
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static java.util.List<WebViewCookie> getCookiesForUrl(long id, java.lang.String url) throws WebViewException {
            try {
                return FfiConverterSequenceTypeWebViewCookie.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_get_cookies_for_url(_allocator, 
            id, FfiConverterString.INSTANCE.lower(url), _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static java.lang.String getTitle(long id) throws WebViewException {
            try {
                return FfiConverterString.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_get_title(_allocator, 
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static java.lang.String getUrl(long id) throws WebViewException {
            try {
                return FfiConverterString.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_get_url(_allocator, 
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void goBack(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_go_back(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void goForward(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_go_forward(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static boolean isLoading(long id) throws WebViewException {
            try {
                return FfiConverterBoolean.INSTANCE.lift(
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        return UniffiLib.uniffi_composewebview_wry_fn_func_is_loading(
            id, _status);
    })
    );
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void loadHtml(long id, java.lang.String html) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_load_html(
            id, FfiConverterString.INSTANCE.lower(html), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void loadUrl(long id, java.lang.String url) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_load_url(
            id, FfiConverterString.INSTANCE.lower(url), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void loadUrlWithHeaders(long id, java.lang.String url, java.util.List<HttpHeader> headers) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_load_url_with_headers(
            id, FfiConverterString.INSTANCE.lower(url), FfiConverterSequenceTypeHttpHeader.INSTANCE.lower(headers), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void openDevTools(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_open_dev_tools(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void pumpGtkEvents()  {
            try {
                
    UniffiHelpers.uniffiRustCall( (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_pump_gtk_events(
            _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void pumpWindowsEvents()  {
            try {
                
    UniffiHelpers.uniffiRustCall( (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_pump_windows_events(
            _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void reload(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_reload(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void setBounds(long id, int x, int y, int width, int height) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_set_bounds(
            id, x, y, width, height, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void setCookie(long id, WebViewCookie cookie) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_set_cookie(
            id, FfiConverterTypeWebViewCookie.INSTANCE.lower(cookie), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void setLogEnabled(boolean enabled)  {
            try {
                
    UniffiHelpers.uniffiRustCall( (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_set_log_enabled(
            FfiConverterBoolean.INSTANCE.lower(enabled), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void setNativeLogger(NativeLogger logger)  {
            try {
                
    UniffiHelpers.uniffiRustCall( (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_set_native_logger(
            FfiConverterTypeNativeLogger.INSTANCE.lower(logger), _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

  public static void stopLoading(long id) throws WebViewException {
            try {
                
    UniffiHelpers.uniffiRustCallWithError(new WebViewExceptionErrorHandler(), (_allocator, _status) -> {
        UniffiLib.uniffi_composewebview_wry_fn_func_stop_loading(
            id, _status);
    })
    ;
            } catch (java.lang.RuntimeException _uniffi_ex) {
                
                if (WebViewException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (WebViewException)_uniffi_ex.getCause();
                }
                
                if (InternalException.class.isInstance(_uniffi_ex.getCause())) {
                    throw (InternalException)_uniffi_ex.getCause();
                }
                throw _uniffi_ex;
            }
    }
    

}

