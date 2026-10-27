package uniffi.composewebview_wry;


public enum FfiConverterTypeCookieSameSite implements FfiConverterRustBuffer<CookieSameSite> {
    INSTANCE;

    @Override
    public CookieSameSite read(java.nio.ByteBuffer buf) {
        try {
            return CookieSameSite.values()[buf.getInt() - 1];
        } catch (java.lang.IndexOutOfBoundsException e) {
            throw new java.lang.RuntimeException("invalid enum value, something is very wrong!!", e);
        }
    }

    @Override
    public long allocationSize(CookieSameSite value) {
        return 4L;
    }

    @Override
    public void write(CookieSameSite value, java.nio.ByteBuffer buf) {
        buf.putInt(value.ordinal() + 1);
    }
}




