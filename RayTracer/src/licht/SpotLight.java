package licht;

import color.Color;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 *
 * @author Lena
 */
public class SpotLight extends Light{
    
    /**
     * 
     */
    public final Point3 position;
    
    /**
     * 
     */
    public final Vector3 direction;
    
    /**
     * 
     */
    public final double halfAngle;

    /**
     * 
     * @param position
     * @param direction
     * @param halfAngle
     * @param color 
     */
    public SpotLight(Point3 position, Vector3 direction, double halfAngle, Color color) {
        super(color);
        this.position = position;
        this.direction = direction;
        this.halfAngle = halfAngle;
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
