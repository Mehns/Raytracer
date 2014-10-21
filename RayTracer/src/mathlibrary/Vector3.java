/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 *
 * @author Christian
 */
public class Vector3 {
        public final double x;
    public final double y;
    public final double z;
    public final double magnitude;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = Math.sqrt(x*x + y*y + z*z);
    }
    
}
