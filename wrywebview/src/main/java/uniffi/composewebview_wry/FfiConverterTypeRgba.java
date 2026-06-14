package uniffi.composewebview_wry;


public enum FfiConverterTypeRgba implements FfiConverterRustBuffer<Rgba> {
  INSTANCE;

  @Override
  public Rgba read(java.nio.ByteBuffer buf) {
    return new Rgba(
      FfiConverterByte.INSTANCE.read(buf),
      FfiConverterByte.INSTANCE.read(buf),
      FfiConverterByte.INSTANCE.read(buf),
      FfiConverterByte.INSTANCE.read(buf)
    );
  }

  @Override
  public long allocationSize(Rgba value) {
      return (
            FfiConverterByte.INSTANCE.allocationSize(value.r()) +
            FfiConverterByte.INSTANCE.allocationSize(value.g()) +
            FfiConverterByte.INSTANCE.allocationSize(value.b()) +
            FfiConverterByte.INSTANCE.allocationSize(value.a())
      );
  }

  @Override
  public void write(Rgba value, java.nio.ByteBuffer buf) {
      FfiConverterByte.INSTANCE.write(value.r(), buf);
      FfiConverterByte.INSTANCE.write(value.g(), buf);
      FfiConverterByte.INSTANCE.write(value.b(), buf);
      FfiConverterByte.INSTANCE.write(value.a(), buf);
  }
}



