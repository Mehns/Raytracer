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
import sampling.SamplingPattern;
import texture.SingleColorTexture;

/**
 * Test class for task 3 - lights
 * @author Christian Mehns <s55689@beuth-hochschule.de>
 */
public class Test2_Light {
    
    final Color white;
    final Color grey;
    final Color black;
    final Color red;
    final Color green;
    final Color blue;
    final Color yellow;
    
    final LambertMaterial matGreen;
    final LambertMaterial matRed;
    final LambertMaterial matBlue;
    final LambertMaterial matYellow;
    
    final PhongMaterial matPhongBlue;
    final PhongMaterial matPhongGreen;
    final PhongMaterial matPhongRed;
    final PhongMaterial matPhongYellow;
    
    final BlinnPhongMaterial matBlinnPhongBlue;
    final BlinnPhongMaterial matBlinnPhongGreen;
    final BlinnPhongMaterial matBlinnPhongRed;
    final BlinnPhongMaterial matBlinnPhongYellow;
    
    final PointLight pointLight;
    final DirectionalLight directionalLight;
    final SpotLight spotLight;
    
    final ArrayList<Light> lightList1;
    
    final ArrayList<Light> lightList2;
    
    final ArrayList<Light> lightList3;
    
    final ArrayList<Light> lightList4MultipleLight;
    
    PerspectiveCamera camera;

    public Test2_Light(){
        
        
        this.camera = new PerspectiveCamera(new Point3(4, 4, 4), 
                new Vector3(-1, -1, -1),
                new Vector3(0, 1, 0),
                new SamplingPattern(1,1), 
                Math.PI/4);
        
        
        this.lightList4MultipleLight = new ArrayList<>();
        this.lightList3 = new ArrayList<>();
        this.lightList2 = new ArrayList<>();
        this.lightList1 = new ArrayList<>();
        
        this.white = new Color(1,1,1);
        this.grey = new Color(0.25,0.25,0.25);
        this.black = new Color(0,0,0);
        this.red = new Color(1,0,0);
        this.green = new Color(0,1,0);
        this.blue = new Color(0,0,1);
        this.yellow = new Color(1,1,0);
        
        
        this.matGreen = new LambertMaterial(new SingleColorTexture(green));
        this.matRed = new LambertMaterial(new SingleColorTexture(red));
        this.matBlue = new LambertMaterial(new SingleColorTexture(blue));
        this.matYellow = new LambertMaterial(new SingleColorTexture(yellow));
        
        
        this.matPhongBlue = new PhongMaterial(new SingleColorTexture(blue),
                                        new SingleColorTexture(white), 64);
        this.matPhongGreen = new PhongMaterial(new SingleColorTexture(green),
                                        new SingleColorTexture(white), 64);
        this.matPhongRed = new PhongMaterial(new SingleColorTexture(red),
                                    new SingleColorTexture(white), 64);
        this.matPhongYellow = new PhongMaterial(new SingleColorTexture(yellow),
                                    new SingleColorTexture(white), 64);
        
        
        this.matBlinnPhongBlue = new BlinnPhongMaterial(new SingleColorTexture(blue),
                                        new SingleColorTexture(white), 64);
        this.matBlinnPhongGreen = new BlinnPhongMaterial(new SingleColorTexture(green),
                                        new SingleColorTexture(white), 64);
        this.matBlinnPhongRed = new BlinnPhongMaterial(new SingleColorTexture(red),
                                    new SingleColorTexture(white), 64);
        this.matBlinnPhongYellow = new BlinnPhongMaterial(new SingleColorTexture(yellow),
                                    new SingleColorTexture(white), 64);
        
        
        this.pointLight = new PointLight(new Point3(4, 4, 4), white, false);
        this.directionalLight = new DirectionalLight(new Vector3(-1,-1,-1), white, false);
        this.spotLight = new SpotLight(new Point3(4,4,4), new Vector3(-1,-1,-1), Math.PI/14, white, false);
        
    
    

        lightList1.add(pointLight);


        lightList2.add(directionalLight);


        lightList3.add(spotLight);


        lightList4MultipleLight.add(pointLight);
        lightList4MultipleLight.add(directionalLight);
        lightList4MultipleLight.add(spotLight);
        

    }
    
    public void startAll(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    
    public void test1(){
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
    }
    
    public void test2(){
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
    }
    
    public void test3(){
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
    }
    
    public void test4(){
        //Test Scene 4:
        Plane plane4 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matPhongRed);
        Sphere sphere4 = new Sphere(new Point3(1,1,1),0.5,matPhongGreen);
        AxisAlignedBox box4 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matPhongBlue);
        Triangle triangle4 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matPhongYellow);

        ArrayList geoList4 = new ArrayList();
        geoList4.add(plane4);
        geoList4.add(sphere4);
        geoList4.add(box4);
        geoList4.add(triangle4);

        World world4 = new World(geoList4, lightList2, black);

        RayTracer raytracer4 = new RayTracer(world4, camera);
        
    }
    
    public void test5(){
        //Test Scene 5:
        Plane plane5 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matPhongRed);
        Sphere sphere5 = new Sphere(new Point3(1,1,1),0.5,matPhongGreen);
        AxisAlignedBox box5 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matPhongBlue);
        Triangle triangle5 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matPhongYellow);

        ArrayList geoList5 = new ArrayList();
        geoList5.add(plane5);
        geoList5.add(sphere5);
        geoList5.add(box5);
        geoList5.add(triangle5);
        
        World world5 = new World(geoList5, lightList3, black);
    
        RayTracer raytracer5 = new RayTracer(world5, camera);
    }
    
    public void test6(){
        //Test Scene 6:
        Plane plane6 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), matPhongRed);
        Sphere sphere6 = new Sphere(new Point3(1,1,1),0.5,matPhongGreen);
        AxisAlignedBox box6 = new AxisAlignedBox (new Point3(-1.5,0.5,0.5),new Point3(-0.5,1.5,1.5), matPhongBlue);
        Triangle triangle6 = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), matPhongYellow);

        ArrayList geoList6 = new ArrayList();
        geoList6.add(plane6);
        geoList6.add(sphere6);
        geoList6.add(box6);
        geoList6.add(triangle6);
    
        World world6 = new World(geoList6, lightList3, grey);
    
        RayTracer raytracer6 = new RayTracer(world6, camera);
    
    }
    
    public void test7(){
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
    }
    
    public void test8(){
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
        new Test2_Light();
    }
}
