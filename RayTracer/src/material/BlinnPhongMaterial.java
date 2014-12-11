
package material;

import color.Color;
import geometry.Hit;
import world.World;

/**
 *
 * @author Lena
 */
public class BlinnPhongMaterial extends Material{

    public Color diffuse;
    public Color specular;
    public int exponent;

    /**
     * constructs an instance of a Blinn-Phong-Material
     * @param diffuse
     * @param specular
     * @param exponent 
     */
    public BlinnPhongMaterial(Color diffuse, Color specular, int exponent) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }
    
    @Override
    public Color colorFor(Hit hit, World world) {
        
        return null;
    }
    
}
