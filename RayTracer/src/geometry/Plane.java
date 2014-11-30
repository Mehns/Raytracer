/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import color.Color;
import java.util.Objects;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 *
 * @author Lena
 */
public class Plane extends Geometry{

    /**
     * given Point with 3 coordinates in Plane
     */
    public final Point3 a;
    
    /**
     * given Normal for Plane
     */
    public final Normal3 n;
    
    /**
     * Constructs a new Plane
     * @param a Point with 3 coordinates
     * @param n Normal with 3 components
     * @param color defines the color of the Plane
     */
    public Plane(final Point3 a, final Normal3 n, final Color color) {
        super(color);
        this.a = a;
        this.n = n;
    }

    /**
     * calculates if and where ray and plane hit
     * @param r ray that hits plane
     * @return hit of ray and plane or null
     */
    @Override
    public Hit hit(final Ray r) {
        double divisor = r.d.dot(n);
        if(divisor != 0.0){
            double t = a.sub(r.o).dot(n)/divisor;
            return new Hit(t,r,this);
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.a);
        hash = 41 * hash + Objects.hashCode(this.n);
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
        final Plane other = (Plane) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.n, other.n)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plane{" + "a=" + a + ", n=" + n + '}';
    }
    
}
