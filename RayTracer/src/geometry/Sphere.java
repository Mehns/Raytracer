package geometry;

import color.Color;
import material.Material;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import raytracer.Ray;

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
     * Constructs a Sphere
     * @param c Point with 3 coordinates
     * @param r radius of Sphere
     * @param color defines the color of the Sphere
     */
    public Sphere(final Point3 c, final double r, final Color color) {
        super(color);
        this.c = c;
        this.r = r;
    }
    
    public Sphere(final Point3 c, final double r, final Material material) {
        super(material);
        this.c = c;
        this.r = r;
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
        
        if(d>=0.0){
            final double x1 = (-b+Math.sqrt(d))/(2*a);
            final double x2 = (-b-Math.sqrt(d))/(2*a);
            
            if (x1 < 0.0001 && x2 < 0.0001) return null;
            
            double t = Math.min(x1, x2);
            if(t < 0.0){
                t = Math.max(x1, x2);
            }
            Normal3 normal = r.at(t).sub(this.c).normalized().asNormal();
            return new Hit(t,r,this,normal);
        }        
        return null;
    }
    
    
}
