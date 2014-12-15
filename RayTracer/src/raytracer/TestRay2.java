/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import world.World;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import java.util.ArrayList;
import light.DirectionalLight;
import light.Light;
import light.PointLight;
import light.SpotLight;
import material.BlinnPhongMaterial;
import material.LambertMaterial;
import material.PhongMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;

/**
 * Test class for task 3
 * @author Christian Mehns <s55689@beuth-hichschule.de>
 */
public class TestRay2 {

    public TestRay2(){
        
    //colors
    Color white = new Color(1,1,1);
    Color grey = new Color(0.25,0.25,0.25);
    Color black = new Color(0,0,0);
    Color red = new Color(1,0,0);
    Color green = new Color(0,1,0);
    Color blue = new Color(0,0,1);
    Color yellow = new Color(1,1,0);
    
    //material
    LambertMaterial matGreen = new LambertMaterial(green);
    LambertMaterial matRed = new LambertMaterial(red);
    LambertMaterial matBlue = new LambertMaterial(blue);
    LambertMaterial matYellow= new LambertMaterial(yellow);
    
    PhongMaterial matPhongBlue = new PhongMaterial(blue, white,64);
    PhongMaterial matPhongGreen = new PhongMaterial(green, white,64);
    PhongMaterial matPhongRed = new PhongMaterial(red, white,64);
    PhongMaterial matPhongYellow = new PhongMaterial(yellow, white,64);
    
    //BlinnPhong Material
    BlinnPhongMaterial matBlinnPhongBlue = new BlinnPhongMaterial(blue, white, 64);
    BlinnPhongMaterial matBlinnPhongGreen = new BlinnPhongMaterial(green, white, 64);
    BlinnPhongMaterial matBlinnPhongRed = new BlinnPhongMaterial(red, white, 64);
    BlinnPhongMaterial matBlinnPhongYellow = new BlinnPhongMaterial(yellow, white, 64);
    
    //lights
    PointLight pointLight = new PointLight(new Point3(4, 4, 4), white);
    DirectionalLight directionalLight = new DirectionalLight(new Vector3(-1,-1,-1), white);
    SpotLight spotLight = new SpotLight(new Point3(4,4,4), new Vector3(-1,-1,-1), Math.PI/14, white);
    
    ArrayList<Light> lightList1 = new ArrayList<>();
    lightList1.add(pointLight);
    
    ArrayList<Light> lightList2 = new ArrayList<>();
    lightList2.add(directionalLight);
    
    ArrayList<Light> lightList3 = new ArrayList<>();
    lightList3.add(spotLight);
    
    ArrayList<Light> lightList4MultipleLight = new ArrayList<>();
    lightList4MultipleLight.add(pointLight);
    lightList4MultipleLight.add(directionalLight);
    lightList4MultipleLight.add(spotLight);
    
    //camera
    PerspectiveCamera camera = new PerspectiveCamera(new Point3(4, 4, 4), 
                                                      new Vector3(-1, -1, -1), 
                                                      new Vector3(0, 1, 0), 
                                                      Math.PI/4); 
    
    //Test Scene 1:
    //geometry
    Plane plane1 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), red);
    Sphere sphere1 = new Sphere(new Point3(1,1,1), 0.5, green);
    AxisAlignedBox box1 = new AxisAlignedBox(new Point3(-1.5,0.5,0.5), new Point3(-0.5,1.5,1.5), blue);
    Triangle triangle1 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), yellow);

    ArrayList geoList1 = new ArrayList();
    geoList1.add(plane1);
    geoList1.add(sphere1);
    geoList1.add(box1);
    geoList1.add(triangle1);
        
    //world
    World world1 = new World(geoList1);
    
    RayTracer rayTracer1 = new RayTracer(world1, camera);
    
    
    //Test Scene 2:
    //geometry
    Plane plane2 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matRed);
    Sphere sphere2 = new Sphere(new Point3(1,1,1),0.5,matGreen);
    AxisAlignedBox box2 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matBlue);
    Triangle triangle2 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matYellow);
    
    ArrayList geoList2 = new ArrayList();
    geoList2.add(plane2);
    geoList2.add(sphere2);
    geoList2.add(box2);
    geoList2.add(triangle2);
    
    World world2 = new World(geoList2, lightList1, black);
    
    RayTracer rayTracer2 = new RayTracer(world2, camera);

    //Test Scene 3:
    //geometry
    Plane plane3 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matPhongRed);
    Sphere sphere3 = new Sphere(new Point3(1,1,1),0.5,matPhongGreen);
    AxisAlignedBox box3 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matPhongBlue);
    Triangle triangle3 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matPhongYellow);
    
    ArrayList geoList3 = new ArrayList();
    geoList3.add(plane3);
    geoList3.add(sphere3);
    geoList3.add(box3);
    geoList3.add(triangle3);
    
    World world3 = new World(geoList3, lightList1, black);
    
    RayTracer rayTracer3 = new RayTracer(world3, camera);

    
    //Test Scene 4:
    
    World world4 = new World(geoList3, lightList2, black);
    
    RayTracer raytracer4 = new RayTracer(world4, camera);
    
    
    //Test Scene 5:
    
    World world5 = new World(geoList3, lightList3, black);
    
    RayTracer raytracer5 = new RayTracer(world5, camera);

    
    //Test Scene 6:
    
    World world6 = new World(geoList3, lightList3, grey);
    
    RayTracer raytracer6 = new RayTracer(world6, camera);
    
    //Test Scene 7:
    Plane plane7 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matBlinnPhongRed);
    Sphere sphere7 = new Sphere(new Point3(1,1,1),0.5,matBlinnPhongGreen);
    AxisAlignedBox box7 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matBlinnPhongBlue);
    Triangle triangle7 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matBlinnPhongYellow);
    
    ArrayList geoList7 = new ArrayList();
    geoList7.add(plane7);
    geoList7.add(sphere7);
    geoList7.add(box7);
    geoList7.add(triangle7);
    World world7 = new World(geoList7, lightList2, black);
    
    RayTracer raytracer7 = new RayTracer(world7, camera);
    
    
    //Test Scene 8:
    /*all three Lightsources in one scene*/
    Plane plane8 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matBlinnPhongRed);
    Sphere sphere8 = new Sphere(new Point3(1,1,1),0.5,matBlinnPhongGreen);
    AxisAlignedBox box8 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matBlinnPhongBlue);
    Triangle triangle8 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matBlinnPhongYellow);
    
    ArrayList geoList8 = new ArrayList();
    geoList8.add(plane8);
    geoList8.add(sphere8);
    geoList8.add(box8);
    geoList8.add(triangle8);
    World world8 = new World(geoList8, lightList4MultipleLight, black);
    
    RayTracer raytracer8 = new RayTracer(world8, camera);
    }

    
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new TestRay2();
    }
}
