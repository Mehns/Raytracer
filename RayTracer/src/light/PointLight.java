package light;

import color.Color;
import geometry.Hit;
import java.util.Objects;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;
import world.World;

/**
 * represents a PointLight
 * @author Lena
 */
public class PointLight extends Light{
    
    /**
     * position of light
     */
    public final Point3 position;

    /**
     * constructs new PointLight
     * @param position of light
     * @param color of light
     * @param castsShadows boolean for shadow
     */
    public PointLight(final Point3 position, final Color color, final boolean castsShadows) {
        super(color, castsShadows);
        this.position = position;
    }
    
    @Override
    public boolean illuminates(final Point3 point, final World world) {
        if(this.castsShadows){
            
            // new ray from given point to light
            //final Ray ray = new Ray(point, directionFrom(point));
            final Ray ray = new Ray(point.add(directionFrom(point).mul(0.0001)), directionFrom(point));
            
            // search for hit with ray
            final Hit hit= world.hit(ray);
            
            // if no hit: point must be illuminated
            if(hit == null){
                return true;
            }
            
            // if t>=tl no shadow: point must be illuminated
            return hit.t >= ray.tOf(position);
        }
        return true;
    }

    @Override
    public Vector3 directionFrom(final Point3 point) {
        return position.sub(point).normalized();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.position);
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
        final PointLight other = (PointLight) obj;
        return Objects.equals(this.position, other.position);
    }

    @Override
    public String toString() {
        return "PointLight{" + "position=" + position + '}';
    }
    
}
