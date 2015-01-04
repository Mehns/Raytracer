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
import world.World;

/**
 *
 * @author Lena
 */
public abstract class ReflectiveMaterial extends Material{

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
    
    public Color colorFor(Hit hit, World world, Tracer tracer) {
        Normal3 hitNormal = hit.normal;
        Color totalColor = this.diffuse.mul(world.ambientColor);
                
        Point3 pointHit = hit.ray.at(hit.t);
        
        for(Light light: world.lightList){
            if(light.illuminates(pointHit, world)){
                Vector3 l = light.directionFrom(pointHit).normalized();
                Vector3 r = l.reflectedOn(hitNormal);
                
                double max = Math.max(0.0, l.dot(hitNormal));
                double max2 = Math.pow(Math.max(0.0, hit.ray.d.mul(-1).dot(r)), this.exponent);
                
                Color lightColor = light.color;
                totalColor = totalColor.add(diffuse.mul(lightColor).mul(max).
                                        add(specular.mul(lightColor).mul(max2)));
            }
        }
        return totalColor;
    }
    
}
