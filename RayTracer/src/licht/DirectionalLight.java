package licht;

import color.Color;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 *
 * @author Lena
 */
public class DirectionalLight extends Light{
    
    /**
     * 
     */
    public final Vector3 direction;

    /**
     * 
     * @param direction
     * @param color 
     */
    public DirectionalLight(Vector3 direction, Color color) {
        super(color);
        this.direction = direction;
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
