package light;

import color.Color;
import java.util.Objects;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * represents a spotlight
 * @author Lena
 */
public class SpotLight extends Light{
    
    /**
     * position of light
     */
    public final Point3 position;
    
    /**
     * direction of light
     */
    public final Vector3 direction;
    
    /**
     * open lense angle of spotlight
     */
    public final double halfAngle;

    /**
     * constructs new spotLight
     * @param position of light
     * @param direction of light
     * @param halfAngle of light
     * @param color of light
     */
    public SpotLight(final Point3 position, final Vector3 direction, final double halfAngle, final Color color) {
        super(color);
        this.position = position;
        this.direction = direction;
        this.halfAngle = halfAngle;
    }

    @Override
    public boolean illuminates(final Point3 point) {
        // cos (gamma) = a*b/|a|*|b|  --> a,b normalized |a|*|b|=1, can drop /|a|*|b|
        Vector3 a = directionFrom(point).mul(-1);
        Vector3 b = direction.normalized();
        return Math.acos(a.dot(b)) <= halfAngle;
    }

    @Override
    public Vector3 directionFrom(final Point3 point) {
        return position.sub(point).normalized();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.position);
        hash = 59 * hash + Objects.hashCode(this.direction);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.halfAngle) ^ (Double.doubleToLongBits(this.halfAngle) >>> 32));
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
        final SpotLight other = (SpotLight) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.direction, other.direction)) {
            return false;
        }
        if (Double.doubleToLongBits(this.halfAngle) != Double.doubleToLongBits(other.halfAngle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpotLight{" + "position=" + position + ", direction=" + direction + ", halfAngle=" + halfAngle + '}';
    }
    
}
