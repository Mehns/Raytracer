package geometry;

import color.Color;
import java.util.Objects;
import material.Material;
import mathlibrary.Mat3x3;
import mathlibrary.Normal3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 *
 * @author Lena
 */
public class Triangle extends Geometry{
    
    /**
     * a edge of triangle
     */
    public final Vector3 a;
    
    /**
     * b edge of triangle
     */
    public final Vector3 b;
    
    /**
     * c edge of triangle
     */
    public final Vector3 c;
    
    /**
     * Contructs a triangle with color
     * @param a edge of triangle
     * @param b edge of triangle
     * @param c edge of triangle
     * @param color of triangle
     */
    public Triangle(final Vector3 a, final Vector3 b, final Vector3 c, final Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     * Contructs a triangle with material
     * @param a edge of triangle
     * @param b edge of triangle
     * @param c edge of triangle
     * @param material of triangle
     */
    public Triangle(final Vector3 a, final Vector3 b, final Vector3 c, final Material material) {
        super(material);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public Hit hit(final Ray r) {
        final Mat3x3 matA = new Mat3x3(a.x-b.x,a.x-c.x,r.d.x,
                                 a.y-b.y,a.y-c.y,r.d.y,
                                 a.z-b.z,a.z-c.z,r.d.z);
        
        final Vector3 vecB = new Vector3(a.x-r.o.x,a.y-r.o.y,a.z-r.o.z);
        
        final Mat3x3 matA1 = matA.changeCol1(vecB);
        
        final Mat3x3 matA2 = matA.changeCol2(vecB);
        
        final Mat3x3 matA3 = matA.changeCol3(vecB);
        
        final double barBeta = matA1.determinant/matA.determinant;
        
        final double barGamma = matA2.determinant/matA.determinant;
       
        final double t = matA3.determinant/matA.determinant;
        
        if(barBeta < 0.0 || barGamma < 0.0 || t < 0.0 || barBeta+barGamma > 1.0){
            return null;
        }
        
        final Normal3 n = a.add(a.sub(b.asNormal()).mul(barBeta).add(c.sub(a.asNormal()).mul(barGamma))).asNormal();
        
        return new Hit(t,r,this,n);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.a);
        hash = 67 * hash + Objects.hashCode(this.b);
        hash = 67 * hash + Objects.hashCode(this.c);
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
        final Triangle other = (Triangle) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
}
