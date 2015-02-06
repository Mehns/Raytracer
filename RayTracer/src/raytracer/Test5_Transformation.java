/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import geometry.Node;
import geometry.Sphere;
import java.util.ArrayList;
import light.PointLight;
import material.BlinnPhongMaterial;
import mathlibrary.Point3;
import mathlibrary.Transform;
import mathlibrary.Vector3;
import world.World;

/**
 * Test for task 5 Transformation
 * @author Lena
 */
public class Test5_Transformation {
    
    final PerspectiveCamera camera1;
    
    final PerspectiveCamera camera2;
    
    final PointLight pointLight;
    
    final ArrayList lightList;
            
    
    public Test5_Transformation(){
        
        this.pointLight = new PointLight(new Point3(8, 8, 8), new Color(1,1,1), false);
        
        this.lightList = new ArrayList();
        lightList.add(pointLight);
        
        this.camera2 = new PerspectiveCamera(new Point3(4, 4, 4), 
                new Vector3(-1, -1, -1),
                new Vector3(0, 1, 0),
                Math.PI/4);
        
        this.camera1 = new PerspectiveCamera(new Point3(8, 8, 8), 
                new Vector3(-1, -1, -1),
                new Vector3(0, 1, 0),
                Math.PI/4);
     }
    
    public void startAll(){
        sphere();
        box();
    }
    
    public void sphere(){
        
        Sphere sphere = new Sphere(new BlinnPhongMaterial(new Color(1,0,0), new Color(1,1,1), 64));
        ArrayList geoList1 = new ArrayList();
            geoList1.add(sphere);
        
        Transform transform1 = new Transform();
        
        Node node = new Node(transform1.rotateY(Math.PI/0.2).rotateZ(Math.PI/0.9).rotateX(Math.PI/1.15).scale(2.0, 0.5, 2.0), geoList1);
        
        ArrayList geoList = new ArrayList();
            geoList.add(node);
        World world1 = new World(geoList, lightList, new Color(0, 0, 0));
        
        RayTracer raytracer1 = new RayTracer(world1, camera1);
        
    }
    
    public void box() {
        
        AxisAlignedBox box = new AxisAlignedBox(new BlinnPhongMaterial(new Color(1,1,0), new Color(1,1,1), 64));
        ArrayList geoList2 = new ArrayList();
            geoList2.add(box);
            
        Transform transform2 = new Transform();
        
        Node nodeBox = new Node(transform2.rotateX(Math.PI/1.17).rotateY(Math.PI/0.2).rotateZ(Math.PI/1.15).scale(1.0, 0.26, 3.7), geoList2);
        
        ArrayList geoListBox = new ArrayList();
            geoListBox.add(nodeBox);
        World world2 = new World(geoListBox, lightList, new Color(0, 0, 0));
        
        RayTracer raytracer2 = new RayTracer(world2, camera2);
    }
    
    /**
     * starts Test
     * @param args 
     */
    public static void main(String[] args) {
        new Test5_Transformation();
    }
}
