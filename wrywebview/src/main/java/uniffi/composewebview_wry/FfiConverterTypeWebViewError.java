package uniffi.composewebview_wry;


public enum FfiConverterTypeWebViewError implements FfiConverterRustBuffer<WebViewException> {
    INSTANCE;

    @Override
    public WebViewException read(java.nio.ByteBuffer buf) {

        return switch(buf.getInt()) {
            case 1 -> new WebViewException.UnsupportedPlatform();
            case 2 -> new WebViewException.InvalidWindowHandle();
            case 3 -> new WebViewException.WebViewNotFound(
                FfiConverterLong.INSTANCE.read(buf)
                );
            case 4 -> new WebViewException.WrongThread(
                FfiConverterLong.INSTANCE.read(buf)
                );
            case 5 -> new WebViewException.WryException(
                FfiConverterString.INSTANCE.read(buf)
                );
            case 6 -> new WebViewException.GtkInit(
                FfiConverterString.INSTANCE.read(buf)
                );
            case 7 -> new WebViewException.Internal(
                FfiConverterString.INSTANCE.read(buf)
                );
            default -> throw new java.lang.RuntimeException("invalid error enum value, something is very wrong!!");
        };
    }

    @Override
    public long allocationSize(WebViewException value) {
        return switch(value) {
            case WebViewException.UnsupportedPlatform x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
            );
            case WebViewException.InvalidWindowHandle x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
            );
            case WebViewException.WebViewNotFound x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
                + FfiConverterLong.INSTANCE.allocationSize(x.v1)
            );
            case WebViewException.WrongThread x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
                + FfiConverterLong.INSTANCE.allocationSize(x.v1)
            );
            case WebViewException.WryException x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
                + FfiConverterString.INSTANCE.allocationSize(x.v1)
            );
            case WebViewException.GtkInit x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
                + FfiConverterString.INSTANCE.allocationSize(x.v1)
            );
            case WebViewException.Internal x -> (
                // Add the size for the Int that specifies the variant plus the size needed for all fields
                4L
                + FfiConverterString.INSTANCE.allocationSize(x.v1)
            );
            default -> throw new java.lang.RuntimeException("invalid error enum value, something is very wrong!!");
        };
    }

    @Override
    public void write(WebViewException value, java.nio.ByteBuffer buf) {
        switch(value) {
            case WebViewException.UnsupportedPlatform x -> {
                buf.putInt(1);
            }
            case WebViewException.InvalidWindowHandle x -> {
                buf.putInt(2);
            }
            case WebViewException.WebViewNotFound x -> {
                buf.putInt(3);
                FfiConverterLong.INSTANCE.write(x.v1, buf);
            }
            case WebViewException.WrongThread x -> {
                buf.putInt(4);
                FfiConverterLong.INSTANCE.write(x.v1, buf);
            }
            case WebViewException.WryException x -> {
                buf.putInt(5);
                FfiConverterString.INSTANCE.write(x.v1, buf);
            }
            case WebViewException.GtkInit x -> {
                buf.putInt(6);
                FfiConverterString.INSTANCE.write(x.v1, buf);
            }
            case WebViewException.Internal x -> {
                buf.putInt(7);
                FfiConverterString.INSTANCE.write(x.v1, buf);
            }
            default -> throw new java.lang.RuntimeException("invalid error enum value, something is very wrong!!");
        };
    }
}




