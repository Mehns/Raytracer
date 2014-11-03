/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 *
 * @author Christian
 */
public class Normal3 {
    /**
     * The x-component of the normal.
     */
    public final double x;
    /**
     * The y-component of the normal.
     */
    public final double y;
    /**
     * The z-component of the normal.
     */
    public final double z;

    /**
     * Constructs and initializes a normal with 3 double components
     * 
     * @param x The X component of this normal
     * @param y The Y component of this normal
     * @param z The Z component of this normal
     */
    public Normal3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * The method multiplies this normal with a constant
     * @param n is a double constant
     * @return a new normal
     */
    public Normal3 mul(final double n) {
        return new Normal3(this.x * n, this.y * n, this.z * n);
    }
    
    /**
     * The method adds a normal to this normal
     * @param n is a normal with 3 components
     * @return a new Normal
     */
    public Normal3 add(final Normal3 n) {
        return new Normal3(this.x + n.x, this.y + n.y, this.z + n.z);
    }
    
    /**
     * The method builds the dot product of this normal and a vector
     * @param v vector which dot product is build with
     * @return the value of the dot product (double)
     */
    public double dot(Vector3 v){
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    @Override
    public String toString() {
        return "Normal3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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
        final Normal3 other = (Normal3) obj;
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
    
}
