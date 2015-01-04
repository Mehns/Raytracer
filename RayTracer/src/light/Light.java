package light;

import color.Color;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import world.World;

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
     * attribute for shadow
     */

    public final boolean castsShadows;
    
    /**
     * constructs new light
     * @param color of light
     * @param castsShadows boolean for shadow
     */
    public Light(final Color color, final boolean castsShadows) {
        this.color = color;
        this.castsShadows = castsShadows;
    }
    
    /**
     * checks if light hits given point
     * @param point to check
     * @param world to check
     * @return true or false
     */
    public abstract boolean illuminates(final Point3 point, final World world);
    
    /**
     * calculates a vector that points towards the light from given point
     * @param point start of the vector
     * @return vector towards the light
     */
    public abstract Vector3 directionFrom(final Point3 point);
}
