package geometry;

import color.Color;
import raytracer.Ray;

/**
 * Basis geometry class 
 * @author Lena
 */
public abstract class Geometry {
    
    /**
     * color component of geometry
     */
    public final Color color;
    
    /**
     * Constructor of class Geometry
     * @param color defines the color of geometry
     */
    public Geometry(final Color color) {
        this.color = color;
    }
    
    /**
     * calculates if and where ray and geometry hit
     * @param r ray that hits this geometry
     * @return smallest hit of geometry and ray
     */
    public abstract Hit hit(final Ray r);
}
