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
import light.PointLight;
import material.LambertMaterial;
import material.ReflectiveMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import texture.SingleColorTexture;
import world.World;

/**
 * Test class for ReflectiveMaterial
 * @author Lena
 */
public class Test4_ReflectiveMaterial {
    public Test4_ReflectiveMaterial(){
        
        SingleColorTexture red = new SingleColorTexture(new Color(1,0,0));
        SingleColorTexture green = new SingleColorTexture(new Color(0,1,0));
        SingleColorTexture blue = new SingleColorTexture(new Color(0,0,1));
        SingleColorTexture darkGrey = new SingleColorTexture(new Color(0.1,0.1,0.1));
        SingleColorTexture grey = new SingleColorTexture(new Color(0.5,0.5,0.5));
        SingleColorTexture black = new SingleColorTexture(new Color(0,0,0));
        SingleColorTexture white = new SingleColorTexture(new Color(1,1,1));
        
        ReflectiveMaterial darkReflMat = new ReflectiveMaterial(darkGrey, black,64,grey);  
        ReflectiveMaterial redReflMat = new ReflectiveMaterial(red, black,64,grey);  
        ReflectiveMaterial greenReflMat = new ReflectiveMaterial(green, black,64,grey);  
        ReflectiveMaterial blueReflMat = new ReflectiveMaterial(blue, black,64,grey);  
        
        
        final Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), darkReflMat);
        
        final Sphere sphereRed = new Sphere(new Point3(-3,1,0), 1, redReflMat);
        final Sphere sphereGreen = new Sphere(new Point3(0,1,0), 1, greenReflMat);
        final Sphere sphereBlue = new Sphere(new Point3(3,1,0), 1, blueReflMat);
        
        ArrayList geoList = new ArrayList();
            geoList.add(plane);
            geoList.add(sphereRed);
            geoList.add(sphereGreen);
            geoList.add(sphereBlue);
        
        PerspectiveCamera camera = new PerspectiveCamera(new Point3(8, 8, 8), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0), 
                                                      Math.PI/4);
        
        PointLight pointLight = new PointLight(new Point3(8, 8, 8), new Color(1,1,1), false);
        ArrayList lightList = new ArrayList();
            lightList.add(pointLight);
        
        World world = new World(geoList, lightList, new Color(0.25, 0.25, 0.25));
        
        RayTracer raytracer = new RayTracer(world, camera);
    }
}
