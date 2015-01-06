/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import color.Color;
import geometry.Hit;
import light.Light;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.Ray;
import world.World;

/**
 *
 * @author Lena
 */
public class ReflectiveMaterial extends Material{

    /**
     * color of the material
     */
    public final Color diffuse;
    
    /**
     * color of glossy reflection
     */
    public final Color specular;
    
    /**
     * intensity of the glossy reflection
     */
    public final int exponent;
    
    /**
     * color of geometry reflection
     */
    public final Color reflection;

    /**
     * creates an instance of a Reflective Material
     * @param diffuse color of the material
     * @param specular color of glossy reflection
     * @param exponent intensity of the glossy reflection
     * @param reflection color of geometry reflection
     */
    public ReflectiveMaterial(Color diffuse, Color specular, int exponent, Color reflection) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
        this.reflection = reflection;
    }
    
    @Override
    public Color colorFor(Hit hit, World world, Tracer tracer) {
        final Normal3 hitNormal = hit.normal;
        Color totalColor = this.diffuse.mul(world.ambientColor);
                
        final Point3 pointOfHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointOfHit, world)){
                final Vector3 l = light.directionFrom(pointOfHit).normalized();
                final Vector3 r = l.reflectedOn(hitNormal);
                
                final double max = Math.max(0.0, l.dot(hitNormal));
                final double max2 = Math.pow(Math.max(0.0, hit.ray.d.mul(-1).dot(r)), this.exponent);
                
                final Color lightColor = light.color;
                totalColor = totalColor.add(diffuse.mul(lightColor).mul(max).
                                        add(specular.mul(lightColor).mul(max2)));
            }
        }
        final Vector3 rd = hit.ray.d.mul(-1).reflectedOn(hitNormal);
        final Color reflect = tracer.colorFor(new Ray(pointOfHit, rd)).mul(reflection);
        return totalColor.add(reflect);
    }
    
}
