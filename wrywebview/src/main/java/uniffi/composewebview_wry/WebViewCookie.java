package uniffi.composewebview_wry;

public class WebViewCookie {
    private java.lang.String name;
    private java.lang.String value;
    private java.lang.String domain;
    private java.lang.String path;
    /**
     * Unix timestamp in milliseconds.
     */
    private java.lang.Long expiresDateMs;
    private boolean isSessionOnly;
    /**
     * Max-Age in seconds.
     */
    private java.lang.Long maxAgeSec;
    private CookieSameSite sameSite;
    private java.lang.Boolean isSecure;
    private java.lang.Boolean isHttpOnly;

    public WebViewCookie(
        java.lang.String name, 
        java.lang.String value, 
        java.lang.String domain, 
        java.lang.String path, 
        java.lang.Long expiresDateMs, 
        boolean isSessionOnly, 
        java.lang.Long maxAgeSec, 
        CookieSameSite sameSite, 
        java.lang.Boolean isSecure, 
        java.lang.Boolean isHttpOnly
    ) {
        
        this.name = name;
        
        this.value = value;
        
        this.domain = domain;
        
        this.path = path;
        
        this.expiresDateMs = expiresDateMs;
        
        this.isSessionOnly = isSessionOnly;
        
        this.maxAgeSec = maxAgeSec;
        
        this.sameSite = sameSite;
        
        this.isSecure = isSecure;
        
        this.isHttpOnly = isHttpOnly;
    }
    
    public java.lang.String name() {
        return this.name;
    }
    
    public java.lang.String value() {
        return this.value;
    }
    
    public java.lang.String domain() {
        return this.domain;
    }
    
    public java.lang.String path() {
        return this.path;
    }
    
    public java.lang.Long expiresDateMs() {
        return this.expiresDateMs;
    }
    
    public boolean isSessionOnly() {
        return this.isSessionOnly;
    }
    
    public java.lang.Long maxAgeSec() {
        return this.maxAgeSec;
    }
    
    public CookieSameSite sameSite() {
        return this.sameSite;
    }
    
    public java.lang.Boolean isSecure() {
        return this.isSecure;
    }
    
    public java.lang.Boolean isHttpOnly() {
        return this.isHttpOnly;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    public void setValue(java.lang.String value) {
        this.value = value;
    }
    public void setDomain(java.lang.String domain) {
        this.domain = domain;
    }
    public void setPath(java.lang.String path) {
        this.path = path;
    }
    public void setExpiresDateMs(java.lang.Long expiresDateMs) {
        this.expiresDateMs = expiresDateMs;
    }
    public void setIsSessionOnly(boolean isSessionOnly) {
        this.isSessionOnly = isSessionOnly;
    }
    public void setMaxAgeSec(java.lang.Long maxAgeSec) {
        this.maxAgeSec = maxAgeSec;
    }
    public void setSameSite(CookieSameSite sameSite) {
        this.sameSite = sameSite;
    }
    public void setIsSecure(java.lang.Boolean isSecure) {
        this.isSecure = isSecure;
    }
    public void setIsHttpOnly(java.lang.Boolean isHttpOnly) {
        this.isHttpOnly = isHttpOnly;
    }

    

    
    @Override
    public boolean equals(java.lang.Object other) {
        if (other instanceof WebViewCookie) {
            WebViewCookie t = (WebViewCookie) other;
            return (
              java.util.Objects.equals(name, t.name) && 
              
              java.util.Objects.equals(value, t.value) && 
              
              java.util.Objects.equals(domain, t.domain) && 
              
              java.util.Objects.equals(path, t.path) && 
              
              java.util.Objects.equals(expiresDateMs, t.expiresDateMs) && 
              
              isSessionOnly == t.isSessionOnly && 
              
              java.util.Objects.equals(maxAgeSec, t.maxAgeSec) && 
              
              java.util.Objects.equals(sameSite, t.sameSite) && 
              
              java.util.Objects.equals(isSecure, t.isSecure) && 
              
              java.util.Objects.equals(isHttpOnly, t.isHttpOnly)
              
            );
        };
        return false;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(value);
        result = 31 * result + java.util.Objects.hashCode(domain);
        result = 31 * result + java.util.Objects.hashCode(path);
        result = 31 * result + java.util.Objects.hashCode(expiresDateMs);
        result = 31 * result + java.lang.Boolean.hashCode(isSessionOnly);
        result = 31 * result + java.util.Objects.hashCode(maxAgeSec);
        result = 31 * result + java.util.Objects.hashCode(sameSite);
        result = 31 * result + java.util.Objects.hashCode(isSecure);
        result = 31 * result + java.util.Objects.hashCode(isHttpOnly);
        return result;
    }

    
    
    

}


