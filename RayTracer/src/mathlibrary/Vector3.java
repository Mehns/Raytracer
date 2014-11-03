
package mathlibrary;

/**
 *
 * @author Christian Mehns
 */

/**
 * This class represents a vector in 3D space.
 */
public class Vector3 {

    /**
     * The x-position of the vector.
     */
    public final double x;
    /**
     * The y-position of the vector.
     */
    public final double y;
    /**
     * The z-position of the vector.
     */
    public final double z;
    /**
     * The magnitude of the vector.
     */
    public final double magnitude;

    /**
     * Constructs and initializes a vector
     * calculates and sets the magnitude
     * @param x The X coordinate of this vector
     * @param y The Y coordinate of this vector
     * @param z The Z coordinate of this vector
     */
    public Vector3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = Math.sqrt(x*x + y*y + z*z);
    }
    
    /**
     * The method adds a vector to this vector
     * @param v is a vector with three components
     * @return a new vector
     */
    public Vector3 add(final Vector3 v){
        return new Vector3(this.x + v.x,
                           this.y + v.y,
                           this.z + v.z
        );
    }
    
    /**
     * The method adds a normal to this vector
     * @param n is a normal with three coordinates
     * @return a new vector
     */
    public Vector3 add(final Normal3 n){
        return new Vector3(
                        this.x + n.x,
                        this.y + n.y,
                        this.z + n.z
        );
    }
    
    /**
     * The method subtracts a normal-vector from this vector
     * @param n is a normal with three coordinates
     * @return a new vector
     */
    public Vector3 sub(final Normal3 n){
        return new Vector3(
                        this.x - n.x,
                        this.y - n.y,
                        this.z - n.z
        );
    }
    
    /**
     * The method multiplicates a constant with this vector
     * @param c the constant that should be mulitplicated with the vector
     * @return a new vector
     */
    public Vector3 mul(final double c){
        return new Vector3(
                        this.x * c,
                        this.y * c,
                        this.z * c
        );
    }
    
    /**
     * The method builds the dot product of this vector and another
     * @param v vector which dot product is build with
     * @return the value of the dot product
     */
    public double dot(final Vector3 v){
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }
    
    /**
     * The method builds the dot product of this vector and a normal-vector
     * @param n normal which dot product is build with
     * @return the value of the dot product
     */
    public double dot(final Normal3 n){
        return this.x * n.x + this.y * n.y + this.z * n.z;
    }
    
    /**
     * The method normalizes a vector
     * @return the normalized vector
     */
    public Vector3 normalized(){
        return this.mul(1 / this.magnitude);
    }
    
    /**
     * The method changes this vector to a Normal3
     * @return new normal
     */
    public Normal3 asNormal(){
        return new Normal3(this.x, this.y, this.z);
    }
    
    /**
     * The method reflects a vector3 on a normal3
     * @param n the normal on which the vector is reflected
     * @return the reflected new vector
     */
    public Vector3 reflectedOn(final Normal3 n){
        return new Vector3( 2 * this.dot(n) * n.x - this.x , 
                            2 * this.dot(n) * n.y - this.y , 
                            2 * this.dot(n) * n.z - this.z );
    }
    
    /**
     * The method builds the cross-product of this vector and another
     * @param v the vector which the cross-product is build with
     * @return the cross-product as a new vector
     */
    public Vector3 x(final Vector3 v){
        final double x = (this.y * v.z) - (this.z * v.y);
        final double y = (this.z * v.x) - (this.x * v.z);
        final double z = (this.x * v.y) - (this.y * v.x);
        return new Vector3(x, y, z);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.magnitude) ^ (Double.doubleToLongBits(this.magnitude) >>> 32));
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
        final Vector3 other = (Vector3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        if (Double.doubleToLongBits(this.magnitude) != Double.doubleToLongBits(other.magnitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vector3{" + "x=" + x + ", y=" + y + ", z=" + z + ", magnitude=" + magnitude + '}';
    }
    
}
