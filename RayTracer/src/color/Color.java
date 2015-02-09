package color;

/**
 * Class that represents a color
 * @author Christian Mehns
 */
public class Color {

    /**
     * r red value of the color
     */
    public final double r;

    /**
     * g green value of the color
     */
    public final double g;

    /**
     * b blue value of the color
     */
    public final double b;

    /**
     * initialize r, g, b
     * checks if values are in between the range
     * @param r red value of the color. Must be between 0 and 1
     * @param g green value of the color. Must be between 0 and 1
     * @param b blue value of the color. Must be between 0 and 1
     */
    public Color(double r, double g, double b) {        
        
        // sets color-value to 0 if it's to small
        // or to 1 if it's higher than 1
        if (r > 1 || r < 0) {
            if (r > 1) {
                this.r = 1.0;
            } else {
                this.r = 0.0;
            }
        } else {
            this.r = r;
        }

        if (g > 1 || g < 0) {
            if (g > 1) {
                this.g = 1.0;
            } else {
                this.g = 0.0;
            }
        } else {
            this.g = g;
        }

        if (b > 1 || b < 0) {
            if (b > 1) {
                this.b = 1.0;
            } else {
                this.b = 0.0;
            }
        } else {
            this.b = b;
        }
    }
    
    /**
     * adds one color to another
     * @param c Color
     * @return a new color
     */
    public Color add(Color c){
        return new Color(this.r + c.r,
                         this.g + c.g,
                         this.b + c.b);
    }
    
    /**
     * subtracts one color from another
     * @param c Color
     * @return a new color
     */
    public Color sub(Color c){
        return new Color(this.r - c.r,
                         this.g - c.g,
                         this.b - c.b);
    }
    
    /**
     * multiplies two colors
     * @param c Color
     * @return a new color
     */
    public Color mul(Color c){
        return new Color(this.r * c.r,
                         this.g * c.g,
                         this.b * c.b);
    }
    
    /**
     * multiplies a double value to a color
     * @param v double value
     * @return a new color
     */
    public Color mul(double v){
        return new Color(this.r * v,
                         this.g * v,
                         this.b * v);
    }
}
