package material;

import color.Color;
import geometry.Hit;
import world.World;
/**
 * Represents a general Material
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public abstract class Material {
    
    /**
     * The method returns the Color for one Hit-object
     * @param hit
     * @param world
     * @param tracer
     * @return
     */
    public abstract Color colorFor(final Hit hit, final World world, Tracer tracer);
}