package uniffi.composewebview_wry;


public enum FfiConverterTypeWebViewCookie implements FfiConverterRustBuffer<WebViewCookie> {
  INSTANCE;

  @Override
  public WebViewCookie read(java.nio.ByteBuffer buf) {
    return new WebViewCookie(
      FfiConverterString.INSTANCE.read(buf),
      FfiConverterString.INSTANCE.read(buf),
      FfiConverterOptionalString.INSTANCE.read(buf),
      FfiConverterOptionalString.INSTANCE.read(buf),
      FfiConverterOptionalLong.INSTANCE.read(buf),
      FfiConverterBoolean.INSTANCE.read(buf),
      FfiConverterOptionalLong.INSTANCE.read(buf),
      FfiConverterOptionalTypeCookieSameSite.INSTANCE.read(buf),
      FfiConverterOptionalBoolean.INSTANCE.read(buf),
      FfiConverterOptionalBoolean.INSTANCE.read(buf)
    );
  }

  @Override
  public long allocationSize(WebViewCookie value) {
      return (
            FfiConverterString.INSTANCE.allocationSize(value.name()) +
            FfiConverterString.INSTANCE.allocationSize(value.value()) +
            FfiConverterOptionalString.INSTANCE.allocationSize(value.domain()) +
            FfiConverterOptionalString.INSTANCE.allocationSize(value.path()) +
            FfiConverterOptionalLong.INSTANCE.allocationSize(value.expiresDateMs()) +
            FfiConverterBoolean.INSTANCE.allocationSize(value.isSessionOnly()) +
            FfiConverterOptionalLong.INSTANCE.allocationSize(value.maxAgeSec()) +
            FfiConverterOptionalTypeCookieSameSite.INSTANCE.allocationSize(value.sameSite()) +
            FfiConverterOptionalBoolean.INSTANCE.allocationSize(value.isSecure()) +
            FfiConverterOptionalBoolean.INSTANCE.allocationSize(value.isHttpOnly())
      );
  }

  @Override
  public void write(WebViewCookie value, java.nio.ByteBuffer buf) {
      FfiConverterString.INSTANCE.write(value.name(), buf);
      FfiConverterString.INSTANCE.write(value.value(), buf);
      FfiConverterOptionalString.INSTANCE.write(value.domain(), buf);
      FfiConverterOptionalString.INSTANCE.write(value.path(), buf);
      FfiConverterOptionalLong.INSTANCE.write(value.expiresDateMs(), buf);
      FfiConverterBoolean.INSTANCE.write(value.isSessionOnly(), buf);
      FfiConverterOptionalLong.INSTANCE.write(value.maxAgeSec(), buf);
      FfiConverterOptionalTypeCookieSameSite.INSTANCE.write(value.sameSite(), buf);
      FfiConverterOptionalBoolean.INSTANCE.write(value.isSecure(), buf);
      FfiConverterOptionalBoolean.INSTANCE.write(value.isHttpOnly(), buf);
  }
}



