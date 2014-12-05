package material;

import color.Color;
import geometry.Hit;
import light.Light;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import world.World;

/**
 *
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class LambertMaterial extends Material{
    Color color;
    
    public LambertMaterial(Color color){
        this.color = color;
    }

    @Override
    public Color colorFor(Hit hit, World world) {
        Normal3 hitNormal = hit.normal;
        Color totalColor = this.color;
        
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            Color lightColor = light.color;
            
            if(light.illuminates(pointHit)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                double max = Math.max(0.0, l.dot(hitNormal));
                totalColor = color.mul(max);
            }
        }
        
        return totalColor;
    }
       
}

