package uniffi.composewebview_wry;

public enum FfiConverterOptionalTypeCookieSameSite implements FfiConverterRustBuffer<CookieSameSite> {
  INSTANCE;

  @Override
  public CookieSameSite read(java.nio.ByteBuffer buf) {
    if (buf.get() == (byte)0) {
      return null;
    }
    return FfiConverterTypeCookieSameSite.INSTANCE.read(buf);
  }

  @Override
  public long allocationSize(CookieSameSite value) {
    if (value == null) {
      return 1L;
    } else {
      return 1L + FfiConverterTypeCookieSameSite.INSTANCE.allocationSize(value);
    }
  }

  @Override
  public void write(CookieSameSite value, java.nio.ByteBuffer buf) {
    if (value == null) {
      buf.put((byte)0);
    } else {
      buf.put((byte)1);
      FfiConverterTypeCookieSameSite.INSTANCE.write(value, buf);
    }
  }
}



