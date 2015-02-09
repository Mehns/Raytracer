package geometry;

import color.Color;
import java.util.Objects;
import material.Material;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;
import texture.TexCoord2;

/**
 * represents a sphere
 * @author Lena
 */
public class Sphere extends Geometry{
    
    /**
     * given Point with 3 coordinates in Sphere
     */
    public final Point3 c;
    
    /**
     * radius of Sphere
     */
    public final double r;

    /**
     * Constructs a Sphere with color
     * @param c Point with 3 coordinates
     * @param r radius of Sphere
     * @param color defines the color of the Sphere
     */
    public Sphere(final Point3 c, final double r, final Color color) {
        super(color);
        this.c = c;
        this.r = r;
    }
    
    /**
     * Constructs a Sphere with material
     * @param c Point with 3 coordinates
     * @param r radius of Sphere
     * @param material defines the material of the Sphere
     */
    public Sphere(final Point3 c, final double r, final Material material) {
        super(material);
        this.c = c;
        this.r = r;
    }
    
    /**
     * Constructs a Sphere with material
     * @param material defines the material of the Sphere
     */
    public Sphere(final Material material) {
        super(material);
        this.c = new Point3(0,0,0);
        this.r = 1;
    }

    /**
     * calculates if and where ray and sphere hit
     * @param r ray that hits sphere
     * @return smallest hit of ray and sphere or null
     */
    @Override
    public Hit hit(final Ray r) {

        final double a = r.d.dot(r.d);
        final double b = r.d.dot((r.o.sub(c)).mul(2.0));
        final double c = r.o.sub(this.c).dot(r.o.sub(this.c))-(this.r*this.r);
        
        final double d = (b*b)-(4*a*c);
        
        
        
//        double epsilon = 0.0001;
//        
//        if (d > 0.0 ) {
//            double t1 = (-b + Math.sqrt(d)) / (2 * a);
//            double t2 = (-b - Math.sqrt(d)) / (2 * a);
//            double t = epsilon;
//            if (t1 < epsilon && t2 < epsilon) {
//            t = Math.max(t1, t2);
//            }
//            if (t1 > epsilon && t2 >= epsilon) {
//            t = Math.min(t1, t2);
//            }
//            if (t2 > epsilon && t1 < epsilon) {
//            t = t2;
//            }
//            if (t2 < epsilon && t1 > epsilon) {
//            t = t1;
//            }
//            if (t > epsilon) {
//            Normal3 n = r.at(t).sub(this.c).normalized().asNormal();
//            return new Hit(t, r, this, n, getTextureCoordinate(r.at(t)));
//            }
//        }
        
        
        
        if(d>=0.0){
            final double x1 = (-b+Math.sqrt(d))/(2*a);
            final double x2 = (-b-Math.sqrt(d))/(2*a);
            
            if (x1 < 0.0001 && x2 < 0.0001) return null;
            
            double t = Math.min(x1, x2);
            if(t < 0.0){
                t = Math.max(x1, x2);
            }
            Normal3 normal = r.at(t).sub(this.c).normalized().asNormal();
            TexCoord2 texCoord = getTextureCoordinate(r.at(t));
            return new Hit(t,r,this,normal,texCoord);
        }      
        
        
        
        
        return null;
    }
    
    private TexCoord2 getTextureCoordinate(final Point3 point){

        double theta = Math.acos(point.y);
        double phi = Math.atan2(point.x, point.z);
        
        double u = phi / (Math.PI*2);
        double v = 1 - theta/Math.PI;
        
        return new TexCoord2(u, v);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.c);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
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
        final Sphere other = (Sphere) obj;
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(other.r)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sphere{" + "c=" + c + ", r=" + r + '}';
    }
    
}
