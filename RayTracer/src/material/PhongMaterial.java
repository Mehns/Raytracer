package material;

import color.Color;
import geometry.Hit;
import world.World;
/**
 *
 * @author Christian Mehns <s55689@beuth-hichschule.de>
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
