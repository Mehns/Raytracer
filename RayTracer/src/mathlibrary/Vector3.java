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

    public Vector3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = Math.sqrt(x*x + y*y + z*z);
    }
    
    public Vector3 add(Vector3 v){
        return new Vector3(this.x + v.x,
                           this.y + v.y,
                           this.z + v.z
        );
    }
    
    public Vector3 add(Normal3 n){
        return new Vector3(
                        this.x + n.x,
                        this.y + n.y,
                        this.z + n.z
        );
    }
    
    public Vector3 sub(Normal3 n){
        return new Vector3(
                        this.x - n.x,
                        this.y - n.y,
                        this.z - n.z
        );
    }
    
    public Vector3 mul(double c){
        return new Vector3(
                        this.x * c,
                        this.y * c,
                        this.z * c
        );
    }
    
    // Dotproduct of existing and given Vector3. returns double
    public double dot(Vector3 v){
        return this.x * v.x + this.x * v.x + this.x * v.x;
    }
    
    
    
}
