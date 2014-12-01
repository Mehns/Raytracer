package geometry;

import java.util.Objects;
import raytracer.Ray;

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
     * Constructor of class Hit
     * initializes t, ray, geo
     * @param t where ray and geometry hit
     * @param ray Ray that hits geometry
     * @param geo Geometry that hits ray
     */
    public Hit(final double t, final Ray ray, final Geometry geo) {
        this.t = t;
        this.ray = ray;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Hit{" + "t=" + t + ", ray=" + ray + ", geo=" + geo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.t) ^ (Double.doubleToLongBits(this.t) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.ray);
        hash = 97 * hash + Objects.hashCode(this.geo);
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
        return true;
    }
    
}
