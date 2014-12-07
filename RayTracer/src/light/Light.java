package light;

import color.Color;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * abstract basis class for light
 * @author Lena
 */
public abstract class Light {
    
    /**
     * color component
     */
    public final Color color;

    /**
     * constructs new light
     * @param color of light
     */
    public Light(final Color color) {
        this.color = color;
    }
    
    /**
     * checks if light hits given point
     * @param point to check
     * @return true or false
     */
    public abstract boolean illuminates(final Point3 point);
    
    /**
     * calculates a vector that points towards the light from given point
     * @param point start of the vector
     * @return vector towards the light
     */
    public abstract Vector3 directionFrom(final Point3 point);
}
