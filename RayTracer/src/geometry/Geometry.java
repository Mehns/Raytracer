package geometry;

import color.Color;
import material.Material;
import material.SingleColorMaterial;
import raytracer.Ray;
import texture.SingleColorTexture;

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
                                                        new SingleColorTexture(new Color(0.5,0.5,0.5)));
    
    /**
     * Constructor of class Geometry
     * sets a default material
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
     * Constructor of class Geometry
     * sets a default material with given color
     * @param color defines the color of geometry
     */
    public Geometry(final Color color) {
        this.material = new SingleColorMaterial(new SingleColorTexture(color));
    }
    
    /**
     * calculates if and where ray and geometry hit
     * @param r ray that hits this geometry
     * @return smallest hit of geometry and ray
     */
    public abstract Hit hit(final Ray r);
}
