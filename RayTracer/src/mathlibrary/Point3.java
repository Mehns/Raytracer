
package mathlibrary;

/**
 * This class represents a point with 3 coordinates.
 * @author Christian Mehns
 */

public class Point3 {

    /**
     * The x-position of the point.
     */
    public final double x;
    /**
     * The y-position of the point.
     */
    public final double y;
    /**
     * The z-position of the point.
     */
    public final double z;
    
    /**
     * Constructor
     * Constructs and initializes a point at the specified (x,y,z) location in the coordinate space
     * 
     * @param x The X coordinate of this point
     * @param y The Y coordinate of this point
     * @param z The Z coordinate of this point
     */
    public Point3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * The method subtracts a point from this point
     * @param p is a point with 3 coordinates
     *      Must not be null.
     * @return a new Vector wit 3 components
     */
    public Vector3 sub(final Point3 p){
        if(p == null){
            throw new IllegalArgumentException("The parameter " + p + " must not be null.");
        }
        return new Vector3( x-p.x,
                            y-p.y,
                            z-p.z);
    }
    
    /**
     * The method subtracts a vector from this point
     * @param v is a vector with 3 components
     *      Must not be null.
     * @return a new point with 3 coordinates
     */
    public Point3 sub(final Vector3 v){
        if(v == null){
            throw new IllegalArgumentException("The parameter " + v + " must not be null.");
        }
        return new Point3( x-v.x,
                           y-v.y,
                           z-v.z);
    }
    
    /**
     * The method adds a vector to this point
     * @param v is a vector with 3 components
     *      Must not be null.
     * @return a new point with 3 coordinates
     */
    public Point3 add(final Vector3 v){
        if(v == null){
            throw new IllegalArgumentException("The parameter " + v + " must not be null.");
        }
        return new Point3( x+v.x,
                           y+v.y,
                           z+v.z);
    }     

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Point3 other = (Point3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Point3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
        
}
