/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 *
 * @author Christian Mehns
 */

/**
 * This class represents a point in 3D space.
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
     * @param p is a point with three coordinates
     * @return a new Vector
     */
    public Vector3 sub(final Point3 p){
        return new Vector3( x-p.x,
                        y-p.y,
                        z-p.z);
    }
    
    /**
     * The method subtracts a vector from this point
     * @param v is a vector with three coordinates
     * @return a new point
     */
    public Point3 sub(final Vector3 v){
        return new Point3( x-v.x,
                           y-v.y,
                           z-v.z);
    }
    
    /**
     * The method adds a vector from this point
     * @param v is a vector with three coordinates
     * @return a new point
     */
    public Point3 add(final Vector3 v){
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
