/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import color.Color;
import geometry.Geometry;
import java.util.ArrayList;
import raytracer.Ray;
import geometry.Hit;
import java.util.Objects;

/**
 * represents a world
 * @author Lena
 */
public class World {
    
    /**
     * list of all geometries
     */
    public final ArrayList<Geometry> list;
    
    /**
     * background color if no hit with ray
     */
    public final Color backgroundColor;

    /**
     * Constructs a new world
     * @param list lists all geometries in world
     */
    public World(final ArrayList<Geometry> list) {
        this.list = list;
        this.backgroundColor = new Color(0,0,0);
    }
    
    /**
     * looks for the minimal hit of ray and geometry
     * @param r ray that might hit geometries
     * @return minimal hit
     */
    public Hit hit(final Ray r) {
        Hit hit = null;
        ArrayList<Hit> hitList = new ArrayList<>();
        for (Geometry geometry: list){
            hit = geometry.hit(r);
            if(hit!=null){
                hitList.add(hit);
            }    
        }
        double minT = Double.MAX_VALUE;
        for (Hit h: hitList){
            if(h.t<minT){
                minT = h.t;
            }
            hit = h;
        }
        return hit;
}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.list);
        hash = 79 * hash + Objects.hashCode(this.backgroundColor);
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
        final World other = (World) obj;
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        if (!Objects.equals(this.backgroundColor, other.backgroundColor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "World{" + "list=" + list + ", backgroundColor=" + backgroundColor + '}';
    }
    
}
