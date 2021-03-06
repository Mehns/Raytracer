package material;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import light.Light;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import texture.Texture;
import world.World;
/**
 * represents a Phong material 
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class PhongMaterial extends Material{
    
    /**
     * color of the material
     */
    public final Texture diffuse;
    
    /**
     * color of glossy reflection
     */
    public final Texture specular;
    
    /**
     * intensity of the glossy reflection
     */
    public final int exponent;

    /**
     * creates an instance of a Phong material
     * @param diffuse the color of the material
     * @param specular the color of glossy reflection
     * @param exponent the intensity of the glossy reflection
     */
    public PhongMaterial(final Texture diffuse, final Texture specular, final int exponent) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {
        Normal3 hitNormal = hit.normal;
        final double uCoord = hit.texCoord.u;
        final double vCoord = hit.texCoord.v;
        
        final Color difColor = this.diffuse.getColor(uCoord, vCoord);
        final Color specColor = this.specular.getColor(uCoord, vCoord);
        Color totalColor = difColor.mul(world.getAmbientColor());
                
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit, world)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                Vector3 r = l.reflectedOn(hitNormal);
                
                double max = Math.max(0.0, l.dot(hitNormal));
                double max2 = Math.pow(Math.max(0.0, hit.ray.d.mul(-1).dot(r)), this.exponent);
                
                Color lightColor = light.color;
                totalColor = totalColor.add(difColor.mul(lightColor).mul(max).
                                        add(specColor.mul(lightColor).mul(max2)));
            }
        }
        return totalColor;
    }

    @Override
    public String toString() {
        return "PhongMaterial{" + "diffuse=" + diffuse + ", specular=" + specular + ", exponent=" + exponent + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PhongMaterial other = (PhongMaterial) obj;
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
