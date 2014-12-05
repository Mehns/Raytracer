/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import world.World;
import geometry.Plane;
import geometry.Sphere;
import java.util.ArrayList;
import light.DirectionalLight;
import light.Light;
import light.PointLight;
import material.LambertMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 *
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public class TestRay2 {

    public TestRay2(){
        
    //Test1
        
    //colors
    Color white = new Color(1,1,1);
    Color red = new Color(1,0,0);
    Color green = new Color(0,1,0);
    
    //material
    LambertMaterial material1 = new LambertMaterial(green);
    LambertMaterial material2 = new LambertMaterial(red);
        
    //geometry
    Plane plane1 = new Plane(new Point3(0,-1,0), new Normal3(0,1,0), material1);
    Sphere sphere1 = new Sphere(new Point3(1,1,8),1.0,material2);
    
    ArrayList geoList1 = new ArrayList();
    geoList1.add(plane1);
    geoList1.add(sphere1);
    
    //camera
    PerspectiveCamera camera1 = new PerspectiveCamera(new Point3(4, 4, 4), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0), 
                                                      Math.PI/4);
         
    
    //lights
    PointLight light1 = new PointLight(new Point3(1, 3, 1), white);
    DirectionalLight light2 = new DirectionalLight(new Vector3(-1,-1,-1), white);
    ArrayList<Light> lightList1 = new ArrayList<>();
    lightList1.add(light1);
    
    //world
    World world1 = new World(geoList1,lightList1, white);
    PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0),Math.PI/4);

    RayTracer rayTracer1 = new RayTracer(world1, cam1);

    
    }

    
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new TestRay2();
    }
}
