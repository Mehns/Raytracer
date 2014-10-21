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
        
    
}
