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
import java.util.ArrayList;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 *
 * @author Lena
 */
public class TestRay {
    
    
    public TestRay(){
        
        Plane plane = new Plane(new Point3(0,-1,0), new Normal3(0,1,0), new Color(0,1,0));
        ArrayList list1 = new ArrayList();
        list1.add(plane);
        World world1 = new World(list1);
        PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0),Math.PI/4);
        
        RayTracer rayTracer1 = new RayTracer(world1, cam1);
        //OrthographicCamera camera1 = new OrthographicCamera();
    }
    
    public static void main(String[] args) {
        new TestRay();
    }
}
