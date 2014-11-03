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
public class Mat3x3 {
    public final double m11;
    public final double m12;
    public final double m13;
    public final double m21;
    public final double m22;
    public final double m23;
    public final double m31;
    public final double m32;
    public final double m33;
    public final double determinant;

    public Mat3x3(final double m11,final double m12, final double m13, final double m21, final double m22, 
                    final double m23, final double m31, final double m32, final double m33) {
        
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
    
    public Mat3x3 mul (final Mat3x3 m){
        return new Mat3x3(
                        this.m11 * m.m11 + this.m12 * m.m21 + this.m13 * m.m31,
                        this.m11 * m.m12 + this.m12 * m.m22 + this.m13 * m.m32,
                        this.m11 * m.m13 + this.m12 * m.m23 + this.m13 * m.m33,
                        this.m21 * m.m11 + this.m22 * m.m21 + this.m23 * m.m31,
                        this.m21 * m.m12 + this.m22 * m.m22 + this.m23 * m.m32,
                        this.m21 * m.m12 + this.m22 * m.m23 + this.m23 * m.m33,
                        this.m31 * m.m11 + this.m32 * m.m21 + this.m33 * m.m31,
                        this.m31 * m.m12 + this.m32 * m.m22 + this.m33 * m.m32,
                        this.m31 * m.m13 + this.m32 * m.m23 + this.m33 * m.m33
        );
    }
    
    public Vector3 mul (final Vector3 m){
        return new Vector3(
                            this.m11 * m.x + this.m12 * m.y + this.m13 * m.z,
                            this.m21 * m.x + this.m22 * m.y + this.m23 * m.z,
                            this.m31 * m.x + this.m32 * m.y + this.m33 * m.z        
        );
    }
    
    public Point3 mul (final Point3 p){
        return new Point3(
                            this.m11 * p.x + this.m12 * p.y + this.m13 * p.z,
                            this.m21 * p.x + this.m22 * p.y + this.m23 * p.z,
                            this.m31 * p.x + this.m32 * p.y + this.m33 * p.z        
        );
    }
    
    public Mat3x3 changeCol1 (final Vector3 v){
        return new Mat3x3(
                            v.x, this.m12, this.m13,
                            v.y, this.m22, this.m23,
                            v.z, this.m32, this.m33
        );
    }

    public Mat3x3 changeCol2 (final Vector3 v){
        return new Mat3x3(
                            this.m11, v.x, this.m13,
                            this.m21, v.y, this.m23,
                            this.m31, v.z, this.m33
        );
    }
    
    public Mat3x3 changeCol3 (final Vector3 v){
        return new Mat3x3(
                            this.m11, this.m12, v.x,
                            this.m21, this.m22, v.y, 
                            this.m31, this.m32, v.z 
        );
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
