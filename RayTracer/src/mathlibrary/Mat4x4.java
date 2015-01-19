/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 * This class represents a 4x4 matrix with 16 components.
 * @author Lena
 */
public class Mat4x4 {

    /**
     * the m11 component of the matrix
     */
    public final double m11;
    
    /**
     * the m12 component of the matrix
     */
    public final double m12;
    
    /**
     * the m13 component of the matrix
     */
    public final double m13;
    
    /**
     * the m14 component of the matrix
     */
    public final double m14;
    
    /**
     * the m21 component of the matrix
     */
    public final double m21;
    
    /**
     * the m22 component of the matrix
     */
    public final double m22;
    
    /**
     * the m23 component of the matrix
     */
    public final double m23;
    
    /**
     * the m24 component of the matrix
     */
    public final double m24;
    
    /**
     * the m31 component of the matrix
     */
    public final double m31;
    
    /**
     * the m32 component of the matrix
     */
    public final double m32;
    
    /**
     * the m33 component of the matrix
     */
    public final double m33;
    
    /**
     * the m34 component of the matrix
     */
    public final double m34;
    
    /**
     * the m41 component of the matrix
     */
    public final double m41;
    
    /**
     * the m42 component of the matrix
     */
    public final double m42;
    
    /**
     * the m43 component of the matrix
     */
    public final double m43;
    
    /**
     * the m44 component of the matrix
     */
    public final double m44;

    /**
     * Constructor
     * constructs a new 4x4 matrix with 16 components
     *
     * @param m11 component of a 4x4 matrix;
     * @param m12 component of a 4x4 matrix;
     * @param m13 component of a 4x4 matrix;
     * @param m14 component of a 4x4 matrix;
     * @param m21 component of a 4x4 matrix;
     * @param m22 component of a 4x4 matrix;
     * @param m23 component of a 4x4 matrix;
     * @param m24 component of a 4x4 matrix;
     * @param m31 component of a 4x4 matrix;
     * @param m32 component of a 4x4 matrix;
     * @param m33 component of a 4x4 matrix;
     * @param m34 component of a 4x4 matrix;
     * @param m41 component of a 4x4 matrix;
     * @param m42 component of a 4x4 matrix;
     * @param m43 component of a 4x4 matrix;
     * @param m44 component of a 4x4 matrix;
     */
    public Mat4x4(final double m11, final double m12, final double m13, final double m14, 
                  final double m21, final double m22, final double m23, final double m24, 
                  final double m31, final double m32, final double m33, final double m34, 
                  final double m41, final double m42, final double m43, final double m44) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;
    }

    /**
     * The method multiplies this 4x4 matrix with a vector
     * assumed w component of matrix is 0
     * @param v is a vector with 3 components.
     * @return new vector with 3 components.
     */
    public Vector3 mul(final Vector3 v) {
        final double x = m11 * v.x + m12 * v.y + m13 * v.z;
        final double y = m21 * v.x + m22 * v.y + m23 * v.z;
        final double z = m31 * v.x + m32 * v.y + m33 * v.z;
        return new Vector3(x, y, z);
    }

    /**
     * The method multiplies this 4x4 matrix with another 4x4 matrix
     * @param m is a 4x4 matrix.
     * @return new 4x4 matrix.
     */
    public Mat4x4 mul(final Mat4x4 m) {
        final double mn11 = m11 * m.m11 + m12 * m.m21 + m13 * m.m31 + m14 * m.m41;
        final double mn12 = m11 * m.m12 + m12 * m.m22 + m13 * m.m32 + m14 * m.m42;
        final double mn13 = m11 * m.m13 + m12 * m.m23 + m13 * m.m33 + m14 * m.m43;
        final double mn14 = m11 * m.m14 + m12 * m.m24 + m13 * m.m34 + m14 * m.m44;
        final double mn21 = m21 * m.m11 + m22 * m.m21 + m23 * m.m31 + m24 * m.m41;
        final double mn22 = m21 * m.m12 + m22 * m.m22 + m23 * m.m32 + m24 * m.m42;
        final double mn23 = m21 * m.m13 + m22 * m.m23 + m23 * m.m33 + m24 * m.m43;
        final double mn24 = m21 * m.m14 + m22 * m.m24 + m23 * m.m34 + m24 * m.m44;
        final double mn31 = m31 * m.m11 + m32 * m.m21 + m33 * m.m31 + m34 * m.m41;
        final double mn32 = m31 * m.m12 + m32 * m.m22 + m33 * m.m32 + m34 * m.m42;
        final double mn33 = m31 * m.m13 + m32 * m.m23 + m33 * m.m33 + m34 * m.m43;
        final double mn34 = m31 * m.m14 + m32 * m.m24 + m33 * m.m34 + m34 * m.m44;
        final double mn41 = m41 * m.m11 + m42 * m.m21 + m43 * m.m31 + m44 * m.m41;
        final double mn42 = m41 * m.m12 + m42 * m.m22 + m43 * m.m32 + m44 * m.m42;
        final double mn43 = m41 * m.m13 + m42 * m.m23 + m43 * m.m33 + m44 * m.m43;
        final double mn44 = m41 * m.m14 + m42 * m.m24 + m43 * m.m34 + m44 * m.m44;
        return new Mat4x4(mn11, mn12, mn13, mn14,
                mn21, mn22, mn23, mn24,
                mn31, mn32, mn33, mn34,
                mn41, mn42, mn43, mn44);
    }

    /**
     * The method multiplies this 4x4 matrix with a point
     * assumed w component of matrix is 1
     * @param p is a point with 3 coordinates.
     * @return new point with 3 coordinates.
     */
    public Point3 mul(final Point3 p) {
        final double x = (m11 * p.x) + (m12 * p.y) + (m13 * p.z) + m14;
        final double y = (m21 * p.x) + (m22 * p.y) + (m23 * p.z) + m24;
        final double z = (m31 * p.x) + (m32 * p.y) + (m33 * p.z) + m34;
        return new Point3(x, y, z);
    }

    /**
     * The method transposes this 4x4 matrix
     * (Spiegelung entlang der Hauptdiagonalen)
     * @return new 4x4 matrix.
     */
    public Mat4x4 transposed() {
        return new Mat4x4(m11, m21, m31, m41,
                          m12, m22, m32, m42, 
                          m13, m23, m33, m43, 
                          m14, m24, m34, m44);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m13) ^ (Double.doubleToLongBits(this.m13) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m14) ^ (Double.doubleToLongBits(this.m14) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m23) ^ (Double.doubleToLongBits(this.m23) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m24) ^ (Double.doubleToLongBits(this.m24) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m31) ^ (Double.doubleToLongBits(this.m31) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m32) ^ (Double.doubleToLongBits(this.m32) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m33) ^ (Double.doubleToLongBits(this.m33) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m34) ^ (Double.doubleToLongBits(this.m34) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m41) ^ (Double.doubleToLongBits(this.m41) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m42) ^ (Double.doubleToLongBits(this.m42) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m43) ^ (Double.doubleToLongBits(this.m43) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.m44) ^ (Double.doubleToLongBits(this.m44) >>> 32));
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
        final Mat4x4 other = (Mat4x4) obj;
        if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m12) != Double.doubleToLongBits(other.m12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m13) != Double.doubleToLongBits(other.m13)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m14) != Double.doubleToLongBits(other.m14)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m21) != Double.doubleToLongBits(other.m21)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m22) != Double.doubleToLongBits(other.m22)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m23) != Double.doubleToLongBits(other.m23)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m24) != Double.doubleToLongBits(other.m24)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m31) != Double.doubleToLongBits(other.m31)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m32) != Double.doubleToLongBits(other.m32)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m33) != Double.doubleToLongBits(other.m33)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m34) != Double.doubleToLongBits(other.m34)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m41) != Double.doubleToLongBits(other.m41)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m42) != Double.doubleToLongBits(other.m42)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m43) != Double.doubleToLongBits(other.m43)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m44) != Double.doubleToLongBits(other.m44)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mat4x4{" + "m11=" + m11 + ", m12=" + m12 + ", m13=" + m13 + ", m14=" + m14 + ", m21=" + m21 + ", m22=" + m22 + ", m23=" + m23 + ", m24=" + m24 + ", m31=" + m31 + ", m32=" + m32 + ", m33=" + m33 + ", m34=" + m34 + ", m41=" + m41 + ", m42=" + m42 + ", m43=" + m43 + ", m44=" + m44 + '}';
    }
    
}
