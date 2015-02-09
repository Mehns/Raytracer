package raytracer;

import camera.OrthographicCamera;
import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import world.World;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import java.util.ArrayList;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import sampling.SamplingPattern;

/**
 * Testclass for raytracer:
 * creates 4 Frames with given images
 * @author Lena
 */
public class Test1_Geometries {
    
    /**
     * creates 4 Frames with given geometries and cameras
     */
    public Test1_Geometries(){
        
    }
    
    public void startAll(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    
    public void test1(){
        //Test1
        Plane plane = new Plane(new Point3(0,-1,0), new Normal3(0,1,0), new Color(0,1,0));
        ArrayList list1 = new ArrayList();
        list1.add(plane);
        World world1 = new World(list1);
        PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        RayTracer rayTracer1 = new RayTracer(world1, cam1);
    }
    
    public void test2(){
        //Test2
        Sphere sphere = new Sphere(new Point3(0,0,-3),0.5,new Color(1,0,0));
        ArrayList list2 = new ArrayList();
        list2.add(sphere);
        World world2 = new World(list2);
        PerspectiveCamera cam2 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        RayTracer rayTracer2 = new RayTracer(world2, cam2);
        
    }
    
    public void test3(){
        //Test3
        Sphere sphere3_1 = new Sphere(new Point3(-1,0,-3),0.5,new Color(1,0,0));
        Sphere sphere3_2 = new Sphere(new Point3( 1,0,-6),0.5,new Color(1,0,0));
        ArrayList list3 = new ArrayList();
        list3.add(sphere3_1);
        list3.add(sphere3_2);
        World world3 = new World(list3);
        PerspectiveCamera cam3 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        RayTracer rayTracer3 = new RayTracer(world3, cam3);
        
    }
    
    public void test4(){
        //Test4
        Sphere sphere4_1 = new Sphere(new Point3(-1,0,-3),0.5,new Color(1,0,0));
        Sphere sphere4_2 = new Sphere(new Point3( 1,0,-6),0.5,new Color(1,0,0));
        ArrayList list4 = new ArrayList();
        list4.add(sphere4_1);
        list4.add(sphere4_2);
        World world4 = new World(list4);
        OrthographicCamera cam4 = new OrthographicCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), 3);
        
        RayTracer rayTracer4 = new RayTracer(world4, cam4);
        
    }
    
    public void test5(){
        //Test5 Triangle
        Triangle tri = new Triangle(new Vector3(-0.5,0.5,-3), new Vector3(0.5,0.5,-3), new Vector3(0.5,-0.5,-3), new Color(1,0,1));
        ArrayList list5 = new ArrayList();
        list5.add(tri);
        World world5 = new World(list5);
        PerspectiveCamera cam5 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        RayTracer rayTracer5 = new RayTracer(world5, cam5);
        
    }
    
    public void test6(){
        //Test6 AAB
        AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5,0,-0.5), new Point3(0.5,1,0.5),new Color(0,0,1));
        ArrayList list6 = new ArrayList();
        list6.add(box);
        World world6 = new World(list6);
        PerspectiveCamera cam6 = new PerspectiveCamera(new Point3(3,3,3), new Vector3(-3,-3,-3), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        RayTracer rayTracer6 = new RayTracer(world6, cam6);
        
    }
    
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new Test1_Geometries();
    }
    
}
