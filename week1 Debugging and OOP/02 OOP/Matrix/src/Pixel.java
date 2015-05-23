
public class Pixel {
    public int R;
    public int G;
    public int B;
    
    public Pixel(int red, int green, int blue) {
        setR(red);
        setG(green);
        setB(blue);
    }
    
    public void setR(int red) {
        if (red >= 0 && red <= 255) {
            R = red;
        }
    }
    
    public void setG(int green) {
        if (green >= 0 && green <= 255) {
            G = green;
        }
    }
    
    public void setB(int blue) {
        if (blue >= 0 && blue <= 255) {
            B = blue;
        }
    }
    
    public int getR() {
        return R;
    }
    
    public int getG() {
        return G;
    }
    
    public int getB() {
        return B;
    }
    
    public String toString() {
        return "(" + R + ", " + G + ", " + B + ")";
    }
}
