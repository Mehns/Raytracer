package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import light.Light;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import world.World;

/**
 * represents a Lambert material 
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class LambertMaterial extends Material{
    /**
     * color of material
     */
    public final Color color;
    
    /**
     * creates an instance of a lambert material
     * @param color the color of the material
     */
    public LambertMaterial(final Color color){
        this.color = color;
    }

    @Override
    public Color colorFor(final Hit hit, final World world) {
        Normal3 hitNormal = hit.normal;
        Color totalColor = this.color.mul(world.ambientColor);
                
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                double max = Math.max(0.0, l.dot(hitNormal));
                Color lightColor = light.color;
                totalColor = totalColor.add(color.mul(lightColor).mul(max));
            }
        }
        return totalColor;
    }

    @Override
    public String toString() {
        return "LambertMaterial{" + "color=" + color + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.color);
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
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
}

