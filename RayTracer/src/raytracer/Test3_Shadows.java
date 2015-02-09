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
import java.util.ArrayList;
import light.Light;
import light.PointLight;
import material.LambertMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import sampling.SamplingPattern;
import texture.SingleColorTexture;
import world.World;

/**
 * Test class for task 4 - shadows
 * @author Lena
 */
public class Test3_Shadows {

    public Test3_Shadows() {
        final Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new LambertMaterial(new SingleColorTexture(new Color(0.8,0.8,0.8))));
        final AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5,0,-0.5), new Point3(0.5,1,0.5), new LambertMaterial(new SingleColorTexture(new Color(1,0,0))));
        
        //final Sphere s = new Sphere(new Point3(0.5,1,0.5), 0.5, new LambertMaterial(new Color(1,0,0)));
        
        final ArrayList geoList1 = new ArrayList();
        geoList1.add(plane);
        geoList1.add(box);
        
        final PointLight pointLight = new PointLight(new Point3(8, 8, 0), new Color(1,1,1), true);
        
        final ArrayList<Light> lightList1 = new ArrayList<>();
        lightList1.add(pointLight);
    
        final PerspectiveCamera camera = new PerspectiveCamera(new Point3(8, 8, 8), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0),
                                                      new SamplingPattern(1,1), 
                                                      Math.PI/4);
        
        final World world = new World(geoList1, lightList1, new Color(0,0,0));
        
        final RayTracer rayTracer1 = new RayTracer(world, camera);
    }
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new Test3_Shadows();
    }
    
}
