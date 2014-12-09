package light;

import color.Color;
import java.util.Objects;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * represents a pointlight
 * @author Lena
 */
public class PointLight extends Light{
    
    /**
     * 
     */
    public final Point3 position;

    /**
     * 
     * @param position
     * @param color 
     */
    public PointLight(final Point3 position, final Color color) {
        super(color);
        this.position = position;
    }
    
    @Override
    public boolean illuminates(Point3 point) {
        return true;
    }

    @Override
    public Vector3 directionFrom(Point3 point) {
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
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PointLight{" + "position=" + position + '}';
    }
    
}
