package light;

import color.Color;
import java.util.Objects;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 *
 * @author Lena
 */
public class DirectionalLight extends Light{
    
    /**
     * 
     */
    public final Vector3 direction;

    /**
     * 
     * @param direction
     * @param color 
     */
    public DirectionalLight(Vector3 direction, Color color) {
        super(color);
        this.direction = direction;
    }

    @Override
    public boolean illuminates(Point3 point) {
        return true;
    }

    @Override
    public Vector3 directionFrom(Point3 point) {
        return direction.mul(-1).normalized();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.direction);
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
        final DirectionalLight other = (DirectionalLight) obj;
        if (!Objects.equals(this.direction, other.direction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DirectionalLight{" + "direction=" + direction + '}';
    }
    
}
