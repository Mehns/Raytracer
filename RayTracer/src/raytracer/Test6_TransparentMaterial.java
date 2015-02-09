/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import java.util.ArrayList;
import light.DirectionalLight;
import light.PointLight;
import light.SpotLight;
import material.PhongMaterial;
import material.ReflectiveMaterial;
import material.TransparentMaterial;
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
public class Test6_TransparentMaterial {

    public Test6_TransparentMaterial() {
        SingleColorTexture white = new SingleColorTexture(new Color(1,1,1));
        SingleColorTexture sphereTex = new SingleColorTexture(new Color(1,0.5,0.5));
        SingleColorTexture triangleTex = new SingleColorTexture(new Color(0,1,0));
        ReflectiveMaterial planeMat = new ReflectiveMaterial(white, white, 10, white);
        
        Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), planeMat);
        
        Sphere sphere1 = new Sphere(new Point3(0,1,0), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(1,0,0)), white, 10, sphereTex));
        Sphere sphere2 = new Sphere(new Point3(-1.5,1,0), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(0,1,0)), white, 10, sphereTex));
        Sphere sphere3 = new Sphere(new Point3(1.5,1,0), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(0,0,1)), white, 10, sphereTex));
        Sphere sphere4 = new Sphere(new Point3(0,1,-1.5), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(0,1,1)), white, 10, sphereTex));
        Sphere sphere5 = new Sphere(new Point3(-1.5,1,-1.5), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(1,0,1)), white, 10, sphereTex));
        Sphere sphere6 = new Sphere(new Point3(1.5,1,-1.5), 0.5, new ReflectiveMaterial(new SingleColorTexture(new Color(1,1,0)), white, 10, sphereTex));
    
        Sphere transparentSphere1 = new Sphere(new Point3(0,2,1.5), 0.5, new TransparentMaterial(1.33));
        Sphere transparentSphere2 = new Sphere(new Point3(-1.5,2,1.5), 0.5, new TransparentMaterial(1.33));
        Sphere transparentSphere3 = new Sphere(new Point3(1.5,2,1.5), 0.5, new TransparentMaterial(1.33));
        
        AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5,0,3),new Point3(0.5,1,4),new TransparentMaterial(1.33));
        
        
        Triangle triangle = new Triangle(new Vector3(0.7,0.5,3), new Vector3(1.3,0.5,3), new Vector3(0.7,0.5,4), new PhongMaterial(triangleTex, triangleTex, 20));
    
        ArrayList geos = new ArrayList();
        geos.add(plane);
        geos.add(sphere1);
        geos.add(sphere2);
        geos.add(sphere3);
        geos.add(sphere4);
        geos.add(sphere5);
        geos.add(sphere6);
        geos.add(transparentSphere1);
        geos.add(transparentSphere2);
        geos.add(transparentSphere3);
        geos.add(triangle);
        geos.add(box);
        
        ArrayList lights = new ArrayList();
        lights.add(new SpotLight(new Point3(0,5,-10), new Vector3(0,-1,0), Math.PI/8, new Color(0.3,0.3,0.3), true));
        lights.add(new PointLight(new Point3(5,5,-10), new Color(0.3,0.3,0.3), true));
        lights.add(new DirectionalLight(new Vector3(1,-1,0),  new Color(0.3,0.3,0.3), true));
        
        World world = new World(geos, lights, new Color(0.1,0.1,0.1));
        
        PerspectiveCamera cam = new PerspectiveCamera(new Point3(8, 8, 8), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0),
                                                      new SamplingPattern(1,1), 
                                                      Math.PI/4);
        
        RayTracer raytracer = new RayTracer(world, cam);
        
    }   
}
