package uniffi.composewebview_wry;


public enum FfiConverterTypeHttpHeader implements FfiConverterRustBuffer<HttpHeader> {
  INSTANCE;

  @Override
  public HttpHeader read(java.nio.ByteBuffer buf) {
    return new HttpHeader(
      FfiConverterString.INSTANCE.read(buf),
      FfiConverterString.INSTANCE.read(buf)
    );
  }

  @Override
  public long allocationSize(HttpHeader value) {
      return (
            FfiConverterString.INSTANCE.allocationSize(value.name()) +
            FfiConverterString.INSTANCE.allocationSize(value.value())
      );
  }

  @Override
  public void write(HttpHeader value, java.nio.ByteBuffer buf) {
      FfiConverterString.INSTANCE.write(value.name(), buf);
      FfiConverterString.INSTANCE.write(value.value(), buf);
  }
}



