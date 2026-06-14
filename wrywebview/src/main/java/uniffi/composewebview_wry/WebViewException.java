package uniffi.composewebview_wry;



/**
 * Errors that can occur when working with WebViews.
 */
public class WebViewException extends java.lang.Exception {
    private WebViewException(java.lang.String message) {
      super(message);
    }

    
    public static class UnsupportedPlatform extends WebViewException {
      public UnsupportedPlatform() {
        super(new StringBuilder()
        .toString());
        }

      
      
      
    }
    
    public static class InvalidWindowHandle extends WebViewException {
      public InvalidWindowHandle() {
        super(new StringBuilder()
        .toString());
        }

      
      
      
    }
    
    public static class WebViewNotFound extends WebViewException {
      
      java.lang.Long v1;
      public WebViewNotFound(java.lang.Long v1) {
        super(new StringBuilder()
        .append("v1=")
        .append(v1)
        
        
        .toString());
        this.v1 = v1;
        }

      public java.lang.Long v1() {
        return this.v1;
      }
      
      
      
    }
    
    public static class WrongThread extends WebViewException {
      
      java.lang.Long v1;
      public WrongThread(java.lang.Long v1) {
        super(new StringBuilder()
        .append("v1=")
        .append(v1)
        
        
        .toString());
        this.v1 = v1;
        }

      public java.lang.Long v1() {
        return this.v1;
      }
      
      
      
    }
    
    public static class WryException extends WebViewException {
      
      java.lang.String v1;
      public WryException(java.lang.String v1) {
        super(new StringBuilder()
        .append("v1=")
        .append(v1)
        
        
        .toString());
        this.v1 = v1;
        }

      public java.lang.String v1() {
        return this.v1;
      }
      
      
      
    }
    
    public static class GtkInit extends WebViewException {
      
      java.lang.String v1;
      public GtkInit(java.lang.String v1) {
        super(new StringBuilder()
        .append("v1=")
        .append(v1)
        
        
        .toString());
        this.v1 = v1;
        }

      public java.lang.String v1() {
        return this.v1;
      }
      
      
      
    }
    
    public static class Internal extends WebViewException {
      
      java.lang.String v1;
      public Internal(java.lang.String v1) {
        super(new StringBuilder()
        .append("v1=")
        .append(v1)
        
        
        .toString());
        this.v1 = v1;
        }

      public java.lang.String v1() {
        return this.v1;
      }
      
      
      
    }
     
}

