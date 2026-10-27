package uniffi.composewebview_wry;

public class HttpHeader {
    private java.lang.String name;
    private java.lang.String value;

    public HttpHeader(
        java.lang.String name, 
        java.lang.String value
    ) {
        
        this.name = name;
        
        this.value = value;
    }
    
    public java.lang.String name() {
        return this.name;
    }
    
    public java.lang.String value() {
        return this.value;
    }
    public void setName(java.lang.String name) {
        this.name = name;
    }
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    

    
    @Override
    public boolean equals(java.lang.Object other) {
        if (other instanceof HttpHeader) {
            HttpHeader t = (HttpHeader) other;
            return (
              java.util.Objects.equals(name, t.name) && 
              
              java.util.Objects.equals(value, t.value)
              
            );
        };
        return false;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + java.util.Objects.hashCode(name);
        result = 31 * result + java.util.Objects.hashCode(value);
        return result;
    }

    
    
    

}


