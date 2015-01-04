
package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import light.Light;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import world.World;

/**
 *
 * @author Lena
 */
public class BlinnPhongMaterial extends Material{

    /**
     * color of the material
     */
    public final Color diffuse;
    
    /**
     * color of glossy reflection
     */
    public final Color specular;
    
    /**
     * intensity of the glossy reflection
     */
    public final int exponent;

    /**
     * constructs an instance of a Blinn-Phong-Material
     * @param diffuse color of the material
     * @param specular color of glossy reflection
     * @param exponent intensity of the glossy reflection
     */
    public BlinnPhongMaterial(final Color diffuse, final Color specular, final int exponent) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }
    
    @Override
    public Color colorFor(final Hit hit, final World world) {
        Color totalColor = this.diffuse.mul(world.ambientColor);
        
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit, world)){
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
        return totalColor;
    }
    
    @Override
    public String toString(){
        return "BlinnPhongMaterial{" + "diffuse=" + diffuse + ", specular=" + 
                specular + ", exponent=" + exponent + '}';
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.diffuse);
        hash = 73 * hash + Objects.hashCode(this.specular);
        hash = 73 * hash + this.exponent;
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
        final BlinnPhongMaterial other = (BlinnPhongMaterial) obj;
        if (!Objects.equals(this.diffuse, other.diffuse)) {
            return false;
        }
        if (!Objects.equals(this.specular, other.specular)) {
            return false;
        }
        if (this.exponent != other.exponent) {
            return false;
        }
        return true;
    }
}
