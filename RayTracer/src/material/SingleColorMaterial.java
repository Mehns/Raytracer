package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import static javafx.scene.paint.Color.color;
import texture.Texture;
import world.World;

/**
 * represents a material with one solid color without any shading
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class SingleColorMaterial extends Material{

    /**
     * diffuse texture of Material
     */
    public final Texture diffuse;
    
    /**
     * Constructor of SingleColorMaterial
     * @param diffuse diffuse texture of material
     */
    public SingleColorMaterial(final Texture diffuse){
        this.diffuse = diffuse;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {
        final double uCoord = hit.texCoord.u;
        final double vCoord = hit.texCoord.v;        
        
        return diffuse.getColor(uCoord, vCoord);
    }

    @Override
    public String toString() {
        return "SingleColorMaterial{" + "color=" + diffuse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.diffuse);
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
        if (!Objects.equals(this.diffuse, other.diffuse)) {
            return false;
        }
        return true;
    }
}

