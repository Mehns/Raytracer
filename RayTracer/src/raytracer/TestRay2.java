/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.Geometry;
import geometry.Plane;
import java.util.ArrayList;
import light.DirectionalLight;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import world.World;

/**
 *
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public class TestRay2 {


    //Test1
    Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new Color(0,1,0));
    ArrayList geoList1 = new ArrayList();
    geoList1.add(plane);
    
    //lights
    DirectionalLight light1 = new DirectionalLight(null, null)
    ArrayList lightList1 = new ArrayList();
    
    
    World world1 = new World(geoList1);
    PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0),Math.PI/4);

    RayTracer rayTracer1 = new RayTracer(world1, cam1);

    


    
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new TestRay2();
    }
}
