package camera;

import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 * Abstract Base Class of a Camera
 * @author Christian Mehns
 */
public abstract class Camera {

    /**
     * eye position point
     */
    public final Point3 e;
    
    /**
     * gaze vector
     */
    public final Vector3 g;

    /**
     * up vector
     */
    public final Vector3 t;

    /**
     * new u axis
     */
    public final Vector3 u;

    /**
     * new v axis
     */
    public final Vector3 v;

    /**
     * new w axis
     */
    public final Vector3 w;

    /**
     * Constructor of abstract camera base class 
     * initialize e, g, t and calculates u, v, w
     * @param e Eye postion
     * @param g Gaze vector
     * @param t up vector
     */
    public Camera(Point3 e, Vector3 g, Vector3 t) {
        this.e = e;
        this.g = g;
        this.t = t;
        
        // w = - (g / |g|)
        this.w = g.normalized().mul(-1.0);
        
        // u = t x w / |t x w|
        this.u = t.x(w).normalized();
        
        // v = w x u
        this.v = w.x(u);        
    }
    
    /**
     * returns ray for one pixel
     * @param w width of the picture
     * @param h height of the picture
     * @param x x coordinate of the pixel
     * @param y y coordinate of the pixel
     * @return a generated ray for one given pixel
     */
    public Ray rayFor(int w, int h, int x, int y){
        
        // d = -w
        Vector3 d = this.w.mul(-1);
        
        // o = e + u*(x- ((w-1)/2)) + v*(y-((h-1)/2))
        Point3 o = e.add(u.mul(x-((w-1)/2)).add(v.mul(y-((h-1)/2))));
        
        return new Ray(o, d);
    }
}