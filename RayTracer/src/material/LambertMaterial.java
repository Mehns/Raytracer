package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import static javafx.scene.paint.Color.color;
import light.Light;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import texture.Texture;
import world.World;

/**
 * represents a Lambert material 
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class LambertMaterial extends Material{
    /**
     * color of material
     */
    public final Texture diffuse;
    
    /**
     * creates an instance of a lambert material
     * @param diffuse the diffuse texture of the material
     */
    public LambertMaterial(final Texture diffuse){
        this.diffuse = diffuse;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {
        Normal3 hitNormal = hit.normal;
        
        final double uCoord = hit.texCoord.u;
        final double vCoord = hit.texCoord.v;
        
        final Color difColor = this.diffuse.getColor(uCoord, vCoord);
        Color totalColor = difColor.mul(world.ambientColor);
                
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit, world)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                double max = Math.max(0.0, l.dot(hitNormal));
                Color lightColor = light.color;
                totalColor = totalColor.add(difColor.mul(lightColor).mul(max));
            }
        }
        return totalColor;
    }

    @Override
    public String toString() {
        return "LambertMaterial{" + "color=" + diffuse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.diffuse);
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
        final LambertMaterial other = (LambertMaterial) obj;
        if (!Objects.equals(this.diffuse, other.diffuse)) {
            return false;
        }
        return true;
    }
}

