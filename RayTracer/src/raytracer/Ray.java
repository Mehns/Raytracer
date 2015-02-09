/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * Class that represents a ray in 3D space
 * @author Christian Mehns
 */
public class Ray {
    /** 
     * The origin of the ray
     */
    public final  Point3 o;
    /** 
     * The direction of the ray
     */
    public final Vector3 d;
    /**
     * Constructor
     * Constructs a ray
     * @param o Origin of the ray
     * @param d Direction of the ray
     */
    public Ray(final Point3 o, final Vector3 d) {
        this.o = o;
        this.d = d;
    }
    
    /**
     * Gives the point at a certain distance on this ray
     * @param t distance 
     * @return Point at the given distance
     */
    public Point3 at(final double t){
        // p = o + t*d;
        return o.add(d.mul(t));
    }
    
    /**
     * Gives the distance at a certain Point on the ray
     * @param p Point
     * @return Distance
     */
    public double tOf(final Point3 p){
        // t = (p - o) / d
        return p.sub(o).magnitude / this.d.magnitude;
    }
}
