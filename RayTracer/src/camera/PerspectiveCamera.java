package camera;

import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;

/**
 * Class represents an perspective camera
 * @author Christian
 */
public class PerspectiveCamera extends Camera{
    public final double angle;

    /**
     * initializes e, g, t, and angle
     * @param e eye position
     * @param g gaze vector
     * @param t up vector
     * @param angle factor
     */
    public PerspectiveCamera(Point3 e, Vector3 g, Vector3 t, double angle) {
        super(e, g, t);
        this.angle = angle;
    }

    @Override
    public Ray rayFor(int w, int h, int x, int y) {
        
        double w1 = (double) w;
        double h1 = (double) h;
        double x1 = (double) x;
        double y1 = (double) y;
        
        // o = e
        Point3 o = this.e;
        
        // -w * ((h/2)/tan a)
        Vector3 calc1 = this.w.mul(-1).mul((h1/2) / Math.tan(this.angle/2));
        
        // u * (x - ((w-1)/2))
        Vector3 calc2 = this.u.mul(x1 - ((w1-1)/2));
        
        // v * (y - ((h-1)/2))
        Vector3 calc3 = this.v.mul(y1 - ((h1-1)/2));
        
        // r = -w * ((h/2)/tan a) + u * (x - ((w-1)/2)) + v * (y - ((h-1)/2))
        Vector3 r = calc1.add(calc2.add(calc3));
        
        // d = r / |r|
        Vector3 d = r.normalized();
        
        return new Ray(o,d);        
    }    

    @Override
    public String toString() {
        return "PerspectiveCamera{EyePosition: "+this.e+" GazeVector: "+this.g
                +"UpVector: "+this.t+ "Angle factor=" + this.angle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.angle) ^ (Double.doubleToLongBits(this.angle) >>> 32));
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
        final PerspectiveCamera other = (PerspectiveCamera) obj;
        if (Double.doubleToLongBits(this.angle) != Double.doubleToLongBits(other.angle)) {
            return false;
        }
        return true;
    }
}
