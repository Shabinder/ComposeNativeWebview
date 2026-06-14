package uniffi.composewebview_wry;


public enum FfiConverterSequenceTypeWebViewCookie implements FfiConverterRustBuffer<java.util.List<WebViewCookie>> {
  INSTANCE;

  @Override
  public java.util.List<WebViewCookie> read(java.nio.ByteBuffer buf) {
    int len = buf.getInt();
    return java.util.stream.IntStream.range(0, len).mapToObj(_i -> FfiConverterTypeWebViewCookie.INSTANCE.read(buf)).toList();
  }

  @Override
  public long allocationSize(java.util.List<WebViewCookie> value) {
    long sizeForLength = 4L;
    long sizeForItems = value.stream().mapToLong(inner -> FfiConverterTypeWebViewCookie.INSTANCE.allocationSize(inner)).sum();
    return sizeForLength + sizeForItems;
  }

  @Override
  public void write(java.util.List<WebViewCookie> value, java.nio.ByteBuffer buf) {
    buf.putInt(value.size());
    value.forEach(inner -> FfiConverterTypeWebViewCookie.INSTANCE.write(inner, buf));
  }
}


