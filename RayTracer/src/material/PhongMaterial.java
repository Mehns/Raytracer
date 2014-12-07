package material;

import color.Color;
import geometry.Hit;
import mathlibrary.Normal3;
import world.World;
/**
 *
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class PhongMaterial extends Material{
    public Color diffuse;
    public Color specular;
    public int exponent;

    public PhongMaterial(Color diffuse, Color specular, int exponent) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world) {
        Normal3 normal = hit.normal;
        
    }
}
