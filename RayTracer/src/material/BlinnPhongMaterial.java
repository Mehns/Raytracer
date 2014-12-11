
package material;

import color.Color;
import geometry.Hit;
import light.Light;
import mathlibrary.Point3;
import mathlibrary.Vector3;
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
        Color totalColor = this.diffuse.mul(world.ambientColor);
        
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                Vector3 v = hit.ray.d.mul(-1).normalized();
                
                Vector3 h = l.add(v).normalized();
                
                final double cos = h.dot(hit.normal);
                double max = Math.max(0.0, l.dot(hit.normal));
                double max2 = Math.pow(Math.max(0.0, cos), this.exponent);
                
                Color lightColor = light.color;
                totalColor = totalColor.add(diffuse.mul(lightColor).mul(max).
                                        add(specular.mul(lightColor).mul(max2)));
            }
        }
        return null;
    }
    
}
