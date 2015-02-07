package texture;

import color.Color;

/**
 *
 * @author Christian Mehns
 */
public interface Texture {
    
    /**
     * returns a Color for the given texture coordinate
     * @param u u-coordinate
     * @param v v-coordinate
     * @return Color 
     */
    public Color getColor(double u, double v);
}
