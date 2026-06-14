package uniffi.composewebview_wry;


public class WebViewExceptionErrorHandler implements UniffiRustCallStatusErrorHandler<WebViewException> {
  @Override
  public WebViewException lift(java.lang.foreign.MemorySegment errorBuf){
     return FfiConverterTypeWebViewError.INSTANCE.lift(errorBuf);
  }
}

