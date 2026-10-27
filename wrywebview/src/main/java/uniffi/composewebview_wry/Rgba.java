package uniffi.composewebview_wry;

public class Rgba {
    private byte r;
    private byte g;
    private byte b;
    private byte a;

    public Rgba(
        byte r, 
        byte g, 
        byte b, 
        byte a
    ) {
        
        this.r = r;
        
        this.g = g;
        
        this.b = b;
        
        this.a = a;
    }
    
    public byte r() {
        return this.r;
    }
    
    public byte g() {
        return this.g;
    }
    
    public byte b() {
        return this.b;
    }
    
    public byte a() {
        return this.a;
    }
    public void setR(byte r) {
        this.r = r;
    }
    public void setG(byte g) {
        this.g = g;
    }
    public void setB(byte b) {
        this.b = b;
    }
    public void setA(byte a) {
        this.a = a;
    }

    

    
    @Override
    public boolean equals(java.lang.Object other) {
        if (other instanceof Rgba) {
            Rgba t = (Rgba) other;
            return (
              r == t.r && 
              
              g == t.g && 
              
              b == t.b && 
              
              a == t.a
              
            );
        };
        return false;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + java.lang.Byte.hashCode(r);
        result = 31 * result + java.lang.Byte.hashCode(g);
        result = 31 * result + java.lang.Byte.hashCode(b);
        result = 31 * result + java.lang.Byte.hashCode(a);
        return result;
    }

    
    
    

}


