package geometry;

import color.Color;
import material.Material;
import material.SingleColorMaterial;
import raytracer.Ray;

/**
 * Basis geometry class 
 * @author Lena
 */
public abstract class Geometry {
    
    /**
     * material component of geometry
     */
    public final Material material;
    
    public static final Material BASE_MATERIAL = new SingleColorMaterial(
                                                        new Color(0.5,0.5,0.5));
    
    /**
     * Constructor of class Geometry
     * @param material defines the material of geometry
     */
    public Geometry() {
        this.material = BASE_MATERIAL;
    }
    
    
    /**
     * Constructor of class Geometry
     * @param material defines the material of geometry
     */
    public Geometry(final Material material) {
        this.material = material;
    }
    
    /**
     * calculates if and where ray and geometry hit
     * @param r ray that hits this geometry
     * @return smallest hit of geometry and ray
     */
    public abstract Hit hit(final Ray r);
}
