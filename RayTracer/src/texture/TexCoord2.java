package texture;

/**
 * This class represents a Texture Coordinate
 * @author Christian Mehns
 */
public class TexCoord2 {
    
    /**
     *  u coordinate of texture
     */
    public final double u;
    
    /**
     *  v coordinate of texture
     */
    public final double v;

    /**
     * Constructor
     * constructs a new texture coordinate
     * @param u u-Coordinate of texture
     * @param v v-Coordinate of texture
     */
    public TexCoord2(double u, double v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.u) ^ (Double.doubleToLongBits(this.u) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.v) ^ (Double.doubleToLongBits(this.v) >>> 32));
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
        final TexCoord2 other = (TexCoord2) obj;
        if (Double.doubleToLongBits(this.u) != Double.doubleToLongBits(other.u)) {
            return false;
        }
        if (Double.doubleToLongBits(this.v) != Double.doubleToLongBits(other.v)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TexCoord2{" + "u=" + u + ", v=" + v + '}';
    }
    
    
}
