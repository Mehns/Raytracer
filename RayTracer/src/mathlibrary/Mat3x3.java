/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 * This class represents a 3x3 matrix with 9 components.
 * @author Christian
 */
public class Mat3x3 {
    /**
     * The m11-component of the matrix.
     */
    public final double m11;
    /**
     * The m12-component of the matrix.
     */
    public final double m12;
    /**
     * The m13-component of the matrix.
     */
    public final double m13;
    /**
     * The m21-component of the matrix.
     */
    public final double m21;
    /**
     * The m22-component of the matrix.
     */
    public final double m22;
    /**
     * The m23-component of the matrix.
     */
    public final double m23;
    /**
     * The m31-component of the matrix.
     */
    public final double m31;
    /**
     * The m32-component of the matrix.
     */
    public final double m32;
    /**
     * The m33-component of the matrix.
     */
    public final double m33;
    /**
     * The determinant of the matrix.
     */
    public final double determinant;

    /**
     * Constructor
     * Constructs and initializes a 3x3 matrix with 9 double components.
     * Calculates and sets the determinant of the matrix.
     * @param m11 The m11 component of this matrix
     * @param m12 The m12 component of this matrix
     * @param m13 The m13 component of this matrix
     * @param m21 The m21 component of this matrix
     * @param m22 The m22 component of this matrix
     * @param m23 The m23 component of this matrix
     * @param m31 The m31 component of this matrix
     * @param m32 The m32 component of this matrix
     * @param m33 The m33 component of this matrix
     */
    public Mat3x3(final double m11,final double m12, final double m13,
                  final double m21, final double m22, final double m23,
                  final double m31, final double m32, final double m33) {
        
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        
        determinant = m11 * m22 * m33 + m12 * m23 * m31 + m13 * m21 * m32 
                        - m31 * m22 * m13 - m32 * m23 * m11 - m33 * m21 * m12;
        
    }
    
    /**
     * The method multiplies this 3x3 matrix with another 3x3 matrix
     * @param m is a 3x3 matrix with 9 components
     *      Must not be null.
     * @return a new 3x3 matrix
     */
    public Mat3x3 mul (final Mat3x3 m){
        if(m == null){
            throw new IllegalArgumentException("The parameter " + m + " must not be null.");
        }
        return new Mat3x3(
                        this.m11 * m.m11 + this.m12 * m.m21 + this.m13 * m.m31,
                        this.m11 * m.m12 + this.m12 * m.m22 + this.m13 * m.m32,
                        this.m11 * m.m13 + this.m12 * m.m23 + this.m13 * m.m33,
                        this.m21 * m.m11 + this.m22 * m.m21 + this.m23 * m.m31,
                        this.m21 * m.m12 + this.m22 * m.m22 + this.m23 * m.m32,
                        this.m21 * m.m13 + this.m22 * m.m23 + this.m23 * m.m33,
                        this.m31 * m.m11 + this.m32 * m.m21 + this.m33 * m.m31,
                        this.m31 * m.m12 + this.m32 * m.m22 + this.m33 * m.m32,
                        this.m31 * m.m13 + this.m32 * m.m23 + this.m33 * m.m33);
    }
    
    /**
     * The method multiplies this 3x3 matrix with a vector
     * @param m is a vector with 3 components
     *      Must not be null.
     * @return a new vector with 3 components
     */
    public Vector3 mul (final Vector3 m){
        if(m == null){
            throw new IllegalArgumentException("The parameter " + m + " must not be null.");
        }
        return new Vector3(
                            this.m11 * m.x + this.m12 * m.y + this.m13 * m.z,
                            this.m21 * m.x + this.m22 * m.y + this.m23 * m.z,
                            this.m31 * m.x + this.m32 * m.y + this.m33 * m.z);
    }
    
    /**
     * The method multiplies this 3x3 matrix with a point
     * @param p is a point with 3 coordinates
     *      Must not be null.
     * @return a new point with 3 coordinates
     */
    public Point3 mul (final Point3 p){
        if(p == null){
            throw new IllegalArgumentException("The parameter " + p + " must not be null.");
        }
        return new Point3(
                            this.m11 * p.x + this.m12 * p.y + this.m13 * p.z,
                            this.m21 * p.x + this.m22 * p.y + this.m23 * p.z,
                            this.m31 * p.x + this.m32 * p.y + this.m33 * p.z);
    }
    
    /**
     * The method changes column1 of this 3x3 matrix with a vector
     * @param v is a vector with 3 components
     *      Must not be null.
     * @return a new 3x3 matrix
     */
    public Mat3x3 changeCol1 (final Vector3 v){
        if(v == null){
            throw new IllegalArgumentException("The parameter " + v + " must not be null.");
        }
        return new Mat3x3(
                            v.x, this.m12, this.m13,
                            v.y, this.m22, this.m23,
                            v.z, this.m32, this.m33);
    }

    /**
     * The method changes column2 of this 3x3 matrix with a vector
     * @param v is a vector with 3 components
     *      Must not be null.
     * @return a new 3x3 matrix
     */
    public Mat3x3 changeCol2 (final Vector3 v){
        if(v == null){
            throw new IllegalArgumentException("The parameter " + v + " must not be null.");
        }
        return new Mat3x3(
                            this.m11, v.x, this.m13,
                            this.m21, v.y, this.m23,
                            this.m31, v.z, this.m33);
    }
    
    /**
     * The method changes column3 of this 3x3 matrix with a vector
     * @param v is a vector with 3 components
     * @return a new 3x3 matrix
     */
    public Mat3x3 changeCol3 (final Vector3 v){
        if(v == null){
            throw new IllegalArgumentException("The parameter " + v + " must not be null.");
        }
        return new Mat3x3(
                            this.m11, this.m12, v.x,
                            this.m21, this.m22, v.y, 
                            this.m31, this.m32, v.z);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m13) ^ (Double.doubleToLongBits(this.m13) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m23) ^ (Double.doubleToLongBits(this.m23) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m31) ^ (Double.doubleToLongBits(this.m31) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m32) ^ (Double.doubleToLongBits(this.m32) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.m33) ^ (Double.doubleToLongBits(this.m33) >>> 32));
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
        final Mat3x3 other = (Mat3x3) obj;
        if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m12) != Double.doubleToLongBits(other.m12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m13) != Double.doubleToLongBits(other.m13)) {
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
        if (Double.doubleToLongBits(this.m31) != Double.doubleToLongBits(other.m31)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m32) != Double.doubleToLongBits(other.m32)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m33) != Double.doubleToLongBits(other.m33)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mat3x3{" + "m11=" + m11 + ", m12=" + m12 + ", m13=" + m13 + ", m21=" + m21 + ", m22=" + m22 + ", m23=" + m23 + ", m31=" + m31 + ", m32=" + m32 + ", m33=" + m33 + ", determinant=" + determinant + '}';
    }
  
}
