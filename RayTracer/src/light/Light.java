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
     * calculates a vector that points towards the light for given point
     * @param point to get vector for
     * @return vector for point
     */
    public abstract Vector3 directionFrom(final Point3 point);
}
