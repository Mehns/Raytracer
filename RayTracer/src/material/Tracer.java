
package material;

import color.Color;
import geometry.Hit;
import raytracer.Ray;
import world.World;

/**
 * 
 * @author Lena
 */
public class Tracer {
    
    /**
     * world
     */
    public final World world;
    
    /**
     * recursion depth
     */
    public final int recursions;
    
    public Tracer(World world, int recursions){
        this.world = world;
        this.recursions = recursions;
    }
    
    public Color colorFor(Ray ray){
        if (recursions < 0) {
            return world.backgroundColor;
        }
        final Hit hit = world.hit(ray);
        if (hit == null) {
            return world.backgroundColor;
        }
        return hit.geo.material.colorFor(hit, world, new Tracer(world, recursions - 1));
    }
}
