/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.Plane;
import geometry.Sphere;
import java.util.ArrayList;
import light.DirectionalLight;
import material.LambertMaterial;
import material.PhongMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import sampling.SamplingPattern;
import texture.SingleColorTexture;
import world.World;

/**
 *
 * @author Lena
 */
public class Test7_Sampling {
    
    public Test7_Sampling(){
        Color red = new Color(1,0,0);
        PhongMaterial matPhongRed = new PhongMaterial(new SingleColorTexture(red),
                                    new SingleColorTexture(red), 64);
        final Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new LambertMaterial(new SingleColorTexture(new Color(0.8,0.8,0.8))));
        final Sphere sphere1 = new Sphere(new Point3(2,2,2), 0.5, matPhongRed);
        
        ArrayList geolist = new ArrayList();
        geolist.add(plane);
        geolist.add(sphere1);
        
        DirectionalLight directionalLight = new DirectionalLight(new Vector3(-1,-1,-1), new Color(1,1,1), true);
        ArrayList lightlist = new ArrayList();
        lightlist.add(directionalLight);
        
        World world = new World(geolist, lightlist, new Color(0,0,0));
        
        PerspectiveCamera cam = new PerspectiveCamera(new Point3(8, 8, 8), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0),
                                                      new SamplingPattern(10,10),
                                                      Math.PI/4);
        
        final RayTracer rayTracer1 = new RayTracer(world, cam);
    }
}
