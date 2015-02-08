/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 * Represents a Point with 2 coordinates. Used by SamaplingPattern.
 * @author Lena
 */
public class Point2 {
    
    /**
     * The x-position of the point.
     */
    public final double x;
    
    /**
     * The y-position of the point.
     */
    public final double y;

    /**
     * Constructor
     * Constructs and initializes a point at the specified (x,y) location in the coordinate space.
     * 
     * @param x coordinate of the point.
     * @param y coordinate of the point.
     */
    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }
      
}
