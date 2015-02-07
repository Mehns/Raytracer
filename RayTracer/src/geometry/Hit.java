package geometry;

import java.util.Objects;
import mathlibrary.Normal3;
import raytracer.Ray;
import texture.TexCoord2;

/**
 * represents a hit
 * @author Lena
 */
public class Hit {
    
    /**
     * where ray and geometry hit
     */
    public final double t;
    
    /**
     * Ray that hits geometry
     */
    public final Ray ray;
    
    /**
     * Geometry that hits ray
     */
    public final Geometry geo;
    
    /**
     * Normal of the hit on geometry
     */
    public final Normal3 normal;
    
    /**
     * texture coordinate of the hit
     */
    public final TexCoord2 texCoord;

    /**
     * Constructor of class Hit
     * initializes t, ray, geo
     * @param t where ray and geometry hit
     * @param ray Ray that hits geometry
     * @param geo Geometry that hits ray
     * @param normal Normal of the hit on the geometry
     * @param texCoord texture coordinate of hit
     */
    public Hit(final double t, final Ray ray, final Geometry geo, final Normal3 normal, final TexCoord2 texCoord) {
        this.t = t;
        this.ray = ray;
        this.geo = geo;
        this.normal = normal;
        this.texCoord = texCoord;
    }
    


    @Override
    public String toString() {
        return "Hit{" + "t=" + t + ", ray=" + ray + ", geo=" + geo 
                + ", normal=" + normal +  ", textureCoord=" + texCoord + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.t) ^ (Double.doubleToLongBits(this.t) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.ray);
        hash = 17 * hash + Objects.hashCode(this.geo);
        hash = 17 * hash + Objects.hashCode(this.normal);
        hash = 17 * hash + Objects.hashCode(this.texCoord);
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
        final Hit other = (Hit) obj;
        if (Double.doubleToLongBits(this.t) != Double.doubleToLongBits(other.t)) {
            return false;
        }
        if (!Objects.equals(this.ray, other.ray)) {
            return false;
        }
        if (!Objects.equals(this.geo, other.geo)) {
            return false;
        }
        if (!Objects.equals(this.normal, other.normal)) {
            return false;
        }
        if (!Objects.equals(this.texCoord, other.texCoord)) {
            return false;
        }
        return true;
    }

   
    
}
