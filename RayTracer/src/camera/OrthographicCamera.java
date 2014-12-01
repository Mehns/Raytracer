package camera;

import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 * Class represents an orthographic camera
 * @author Christian Mehns
 */
public class OrthographicCamera extends Camera{

    /**
     * scale factor s
     */
    public final double s;
    
    /**
     * initializes e, g, t, and s
     * @param e eye position
     * @param g gaze vector
     * @param t up vector
     * @param s scale factor
     */
    public OrthographicCamera(Point3 e, Vector3 g, Vector3 t, double s) {
        super(e, g, t);
        this.s = s;
    }

    @Override
    public Ray rayFor(int w, int h, int x, int y) {
        
        // d = -w
        Vector3 d = this.w.mul(-1);
        
        // o = e + s((x-(w-1/2)) / w-1)*u 
        //       + s((y-(h-1/2)) / h-1)*v
        double w1 = (double) w;
        double h1 = (double) h;
        double x1 = (double) x;
        double y1 = (double) y;
        
        double a = w1/h1;
        
        double calc1 = a*this.s * ((x1 - ((w1-1)/2))/(w1-1));
        double calc2 =   this.s * ((y1 - ((h1-1)/2))/(h1-1));
        
        Vector3 utemp = this.u.mul(calc1);
        Vector3 vtemp = this.v.mul(calc2);
        
        Point3 o = this.e.add(utemp.add(vtemp));
        
        return new Ray(o,d);
    } 

    @Override
    public String toString() {
        return "OrthographicCamera{EyePosition: "+this.e+" GazeVector: "+this.g
                +"UpVector: "+this.t+ "Scale factor=" + s + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.s) ^ (Double.doubleToLongBits(this.s) >>> 32));
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
        final OrthographicCamera other = (OrthographicCamera) obj;
        if (Double.doubleToLongBits(this.s) != Double.doubleToLongBits(other.s)) {
            return false;
        }
        return true;
    }
}
