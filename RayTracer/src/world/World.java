package world;

import color.Color;
import geometry.Geometry;
import java.util.ArrayList;
import raytracer.Ray;
import geometry.Hit;
import java.util.Objects;
import light.Light;

/**
 * represents a world
 * @author Lena
 */
public class World {
    
    /**
     * list of all geometries
     */
    public final ArrayList<Geometry> geoList;
    
    /**
     * list of all lights
     */
    public final ArrayList<Light> lightList;
    
    /**
     * Color of ambient light
     */
    private Color ambientColor;

    public Color getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientColor(Color ambientColor) {
        this.ambientColor = ambientColor;
    }
    
    /**
     * background color if no hit with ray
     */
    public final Color backgroundColor;
    
    /**
     * refraction of world
     */
    public final double indexOfRefraction;
    
    public World(final ArrayList<Geometry> geometry){
        this.geoList = geometry;
        this.lightList = new ArrayList<>();
        this.ambientColor = new Color(0.5,0.5,0.5);
        this.backgroundColor = new Color(0,0,0);
        this.indexOfRefraction = 1.0;
    }

    /**
     * Constructs a new world
     * @param geometry lists all geometries in world
     * @param lights lists all lights in world
     * @param ambientColor color of ambient light
     */
    public World(final ArrayList<Geometry> geometry, final ArrayList<Light> lights,
                    final Color ambientColor) {
        this.lightList = lights;
        this.geoList = geometry;
        this.ambientColor = ambientColor;
        this.backgroundColor = new Color(0,0,0);
        this.indexOfRefraction = 1.0;
    }
    
    /**
     * looks for the minimal hit of ray and geometry
     * @param r ray that might hit geometries
     * @return minimal hit
     */
    public Hit hit(final Ray r) {
        Hit hit = null;
        ArrayList<Hit> hitList = new ArrayList<>();
        for (Geometry geometry: geoList){
            hit = geometry.hit(r);
            if(hit!=null){
                hitList.add(hit);
            }    
        }

        for (Hit h: hitList){
            if(hit == null || h.t<hit.t){
                hit = h; 
            }
        }
        return hit;
}
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.geoList);
        hash = 19 * hash + Objects.hashCode(this.lightList);
        hash = 19 * hash + Objects.hashCode(this.ambientColor);
        hash = 19 * hash + Objects.hashCode(this.backgroundColor);
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
        if (!Objects.equals(this.geoList, other.geoList)) {
            return false;
        }
        if (!Objects.equals(this.lightList, other.lightList)) {
            return false;
        }
        if (!Objects.equals(this.ambientColor, other.ambientColor)) {
            return false;
        }
        if (!Objects.equals(this.backgroundColor, other.backgroundColor)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "World{" + "geoList=" + geoList + ", lightList=" + lightList + ", ambientColor=" + ambientColor + ", backgroundColor=" + backgroundColor + '}';
    }
}
