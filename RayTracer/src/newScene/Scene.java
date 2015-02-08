/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newScene;

import camera.Camera;
import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import java.util.ArrayList;
import light.DirectionalLight;
import light.Light;
import light.PointLight;
import light.SpotLight;
import material.LambertMaterial;
import material.PhongMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import raytracer.RayTracer;
import texture.SingleColorTexture;
import world.World;

/**
 *
 * @author sophie
 */
public class Scene {
    
    private final ArrayList geometryList;
    
    private World world;
    
    private Camera cam;
    
    final Color white;
    final Color grey;
    final Color black;
    final Color red;
    final Color green;
    final Color blue;
    final Color yellow;
    
    final PointLight pointLight;
    final DirectionalLight directionalLight;
    final SpotLight spotLight;
    
    final ArrayList<Light> lightList;
    
    final PhongMaterial matPhongYellow;
    
    public Scene(){
        
        this.white = new Color(1,1,1);
        this.grey = new Color(0.25,0.25,0.25);
        this.black = new Color(0,0,0);
        this.red = new Color(1,0,0);
        this.green = new Color(0,1,0);
        this.blue = new Color(0,0,1);
        this.yellow = new Color(1,1,0);
        
        this.pointLight = new PointLight(new Point3(4, 4, 4), white, false);
        
        this.directionalLight = new DirectionalLight(new Vector3(-1,-1,-1), white, false);
        
        this.spotLight = new SpotLight(new Point3(4,4,4), new Vector3(-1,-1,-1), Math.PI/14, white, false);
        
        this.lightList = new ArrayList<>();
        
        this.matPhongYellow = new PhongMaterial(new SingleColorTexture(yellow),
                                    new SingleColorTexture(white), 64);
        
        geometryList = new ArrayList();
        
        world = new World(geometryList, lightList, new Color(0,0,0));
       
    }
    
    /*Sets Camera to Perspective or Orth.*/
    public void setCam(){
        cam = new PerspectiveCamera(new Point3(4, 4, 4), 
                new Vector3(-1, -1, -1),
                new Vector3(0, 1, 0),
                Math.PI/4);
    }
    
    public void spotlight(){
        lightList.add(spotLight);
    }
    
    public void pointlight(){
        lightList.add(pointLight);
    }
    
    public void directionalLight(){
        lightList.add(directionalLight);
    }
    
    public Color stringToColor(String color){
        
        if(color.equals("blue")){
           return blue;
        }
        if(color.equals("red")){
            return red;
        }
        if(color.equals("yellow")){
            return yellow;
        }
        if(color.equals("green")){
            return green;
        }
        
        return null;
    }
    
    public void createSphere(Color color){
        
        Sphere sphere = new Sphere(new Point3(0,0,-3),0.5, new LambertMaterial(new SingleColorTexture(color)));
        geometryList.add(sphere);
    }
    
    public void createBox(Color color){
        AxisAlignedBox box = new AxisAlignedBox(new Point3(-1.5,0.5,0.5), new Point3(-0.5,1.5,1.5), new LambertMaterial(new SingleColorTexture(color)));
        geometryList.add(box);
    }
    
    public void createTriangle(Color color){
        Triangle triangle = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), new LambertMaterial(new SingleColorTexture(color)));
        geometryList.add(triangle);
    }
    
    public void createPlane(Color color){
        Plane plane = new Plane(new Point3(0,-1,0), new Normal3(0,1,0), new LambertMaterial(new SingleColorTexture(color)));
        geometryList.add(plane);
    }
    
    public void drawScene(){
        if(lightList.isEmpty()){
            world.setAmbientColor(white);
        }
        RayTracer rayTracer = new RayTracer(world, cam);
                
    }
}
