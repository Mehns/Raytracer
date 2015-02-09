/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.ArrayList;
import mathlibrary.Transform;
import raytracer.Ray;

/**
 *
 * @author Lena
 */
public class Node extends Geometry{

    /**
     * transformation of objects
     */
    public final Transform transform;
    /**
     * geometries of node
     */
    public final ArrayList<Geometry> geoList;

    /**
     * creates a new node object having a Transform object, a list of geometries
     * and a material as parameter
     *
     * @param transform transformation object
     * @param geoList ArrayList of geometries
     */
    public Node(final Transform transform, final ArrayList<Geometry> geoList) {
        this.transform = transform;
        this.geoList = geoList;
    }
    
    @Override
    public Hit hit(Ray r) {
        final Ray ray = transform.mul(r);
        Hit minimalHit = null;
        for (Geometry geo : geoList) {
            final Hit hit = geo.hit(ray);
            if (minimalHit == null || (hit != null && hit.t < minimalHit.t && hit.t > 0.001)) {
                minimalHit = hit;
            }
        }
        if (minimalHit == null) {
            return null;
        }
        return new Hit(minimalHit.t, ray, minimalHit.geometry, transform.mul(minimalHit.normal), minimalHit.texCoord);
    }
    
}
