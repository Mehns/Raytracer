package material;

import color.Color;
import geometry.Hit;
import world.World;

/**
 * represents a material with one solid color without any shading
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public class SingleColorMaterial extends Material{

    /**
     * Color of Material
     */
    public Color color;
    
    /**
     * Constructor of SingleColorMaterial
     * @param color Color of material
     */
    public SingleColorMaterial(Color color){
        this.color = color;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world) {
        return color;
    }
    
}

