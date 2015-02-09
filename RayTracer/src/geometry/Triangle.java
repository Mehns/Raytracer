package geometry;

import color.Color;
import java.util.Objects;
import material.Material;
import mathlibrary.Mat3x3;
import mathlibrary.Normal3;
import mathlibrary.Vector3;
import raytracer.Ray;
import texture.TexCoord2;

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
     * normal for a
     */
    public final Normal3 na;
    
    /**
     * normal for b
     */
    public final Normal3 nb;
    
    /**
     * normal for c
     */
    public final Normal3 nc;
    
    /**
     * Texture coordinate a
     */
    private final TexCoord2 texCoordA;
    
    /**
     * Texture coordinate b
     */
    private final TexCoord2 texCoordB;
    
    /**
     * Texture coordinate c
     */
    private final TexCoord2 texCoordC;
    
    
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
        
        this.na = b.sub(a.asNormal()).x(c.sub(a.asNormal())).normalized().asNormal();
        this.nb = c.sub(b.asNormal()).x(a.sub(b.asNormal())).normalized().asNormal();
        this.nc = a.sub(c.asNormal()).x(b.sub(c.asNormal())).normalized().asNormal();
        
        
        texCoordA = new TexCoord2(0.0, 0.0);
        texCoordB = new TexCoord2(1.0, 0.0);
        texCoordC = new TexCoord2(0.5, 1.0);
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
        
        this.na = b.sub(a.asNormal()).x(c.sub(a.asNormal())).normalized().asNormal();
        this.nb = c.sub(b.asNormal()).x(a.sub(b.asNormal())).normalized().asNormal();
        this.nc = a.sub(c.asNormal()).x(b.sub(c.asNormal())).normalized().asNormal();
        
        texCoordA = new TexCoord2(1.0, 0.0);
        texCoordB = new TexCoord2(0.0, 0.0);
        texCoordC = new TexCoord2(0.5, 0.5);
    }
    
    /**
     *
     * @param a point a of triangle
     * @param b point b of triangle
     * @param c point c of triangle
     * @param texCoordA texture coordinate a
     * @param texCoordB texture coordinate b
     * @param texCoordC texture coordinate c
     * @param material material of triangle
     */
    public Triangle(final Vector3 a, final Vector3 b, final Vector3 c,
                    final TexCoord2 texCoordA, final TexCoord2 texCoordB, 
                    final TexCoord2 texCoordC, final Material material) {
        
        super(material);
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.na = b.sub(a.asNormal()).x(c.sub(a.asNormal())).normalized().asNormal();
        this.nb = c.sub(b.asNormal()).x(a.sub(b.asNormal())).normalized().asNormal();
        this.nc = a.sub(c.asNormal()).x(b.sub(c.asNormal())).normalized().asNormal();
                
        this.texCoordA = texCoordA;
        this.texCoordB = texCoordB;
        this.texCoordC = texCoordC;
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
        
        final double barAlpha = 1.0 - barBeta - barGamma;
       
        final double t = matA3.determinant/matA.determinant;
        
        if(barBeta < 0.0 || barGamma < 0.0 || t < 0.0001 || barBeta+barGamma > 1.0){
            return null;
        }
        
        final Normal3 n = na.mul(barAlpha).add(nb.mul(barBeta)).add(nc.mul(barGamma));
        
        TexCoord2 texCoord = texCoordA.mul(barAlpha).add(texCoordB).mul(barBeta).add(texCoordC).mul(barGamma);
        
        return new Hit(t,r,this,n,texCoord);
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
