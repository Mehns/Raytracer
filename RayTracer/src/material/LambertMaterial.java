package material;

import color.Color;
import geometry.Hit;
import world.World;

/**
 *
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public class LambertMaterial extends Material{
    Color color;
    
    LambertMaterial(Color color){
        this.color = color;
    }

    @Override
    public Color colorFor(Hit hit, World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}

