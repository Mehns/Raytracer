package licht;

import color.Color;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * represents a pointlight
 * @author Lena
 */
public class PointLight extends Light{
    
    /**
     * 
     */
    public final Point3 position;

    /**
     * 
     * @param position
     * @param color 
     */
    public PointLight(final Point3 position, final Color color) {
        super(color);
        this.position = position;
    }
    
    @Override
    public boolean illuminates(Point3 point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector3 directionFrom(Point3 point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
