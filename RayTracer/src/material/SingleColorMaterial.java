package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import world.World;

/**
 * represents a material with one solid color without any shading
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class SingleColorMaterial extends Material{

    /**
     * Color of Material
     */
    public final Color color;
    
    /**
     * Constructor of SingleColorMaterial
     * @param color Color of material
     */
    public SingleColorMaterial(final Color color){
        this.color = color;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {
        return color;
    }

    @Override
    public String toString() {
        return "SingleColorMaterial{" + "color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleColorMaterial other = (SingleColorMaterial) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
}

