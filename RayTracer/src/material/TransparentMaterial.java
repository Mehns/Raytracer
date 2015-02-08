package material;

import color.Color;
import geometry.Hit;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;
import world.World;

/**
 * class for transparent material
 *
 * @author Lena
 */
public class TransparentMaterial extends Material {

    public final double indexOfRefraction;

    public TransparentMaterial(double indexOfRefraction) {
        this.indexOfRefraction = indexOfRefraction;
    }

    @Override
    public Color colorFor(Hit hit, World world, Tracer tracer) {
        
        final Ray ray = hit.ray;
        
        final Vector3 d = ray.d.normalized(); // direction of ray
        Normal3 n = hit.normal; // normal
        final Vector3 rd = d.reflectedOn(n).normalized(); //reflection of d
        final Point3 p = ray.at(hit.t-0.0001);
        
        double cosPhi1 = d.mul(-1).dot(n); // phi1 angle between n and d or rd 
        
        double quotient; // eta1 / eta2 or eta2 / eta1
        if(cosPhi1 < 0){
            quotient = world.indexOfRefraction / indexOfRefraction; 
            n = n.mul(-1);
        }else{
            quotient = indexOfRefraction / world.indexOfRefraction;
        }
        
        final double radicand = 1 - quotient * quotient * (1 - cosPhi1 * cosPhi1);
        if(radicand < 0){
            return tracer.colorFor(new Ray(p, rd));
        }else{
            final double cosPhi2 = Math.sqrt(radicand); // phi2 angle between -n and t
            final Vector3 t = d.mul(quotient).sub(n.mul(cosPhi2-cosPhi1*quotient));
            // c = R * fr[(p,rd)] + T * fr[(p,t)]
            final double R0 = Math.pow((world.indexOfRefraction - indexOfRefraction) / (world.indexOfRefraction + indexOfRefraction), 2);
            final double R = R0 + (1 - R0) * Math.pow(1 - cosPhi1, 5);
            final double T = 1 - R;
            final Color cr = tracer.colorFor(new Ray(p, rd)).mul(R);
            final Color ct = tracer.colorFor(new Ray(p, t)).mul(T);
            return cr.add(ct);
        }     
    }

}
