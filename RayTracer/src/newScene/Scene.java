/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newScene;

import camera.Camera;
import camera.OrthographicCamera;
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
import material.BlinnPhongMaterial;
import material.LambertMaterial;
import material.Material;
import material.PhongMaterial;
import material.ReflectiveMaterial;
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
    final Color darkgrey;
    
    final PointLight pointLight;
    final DirectionalLight directionalLight;
    final SpotLight spotLight;
    
    final ArrayList<Light> lightList;
    
    public Scene(){
        
        this.white = new Color(1,1,1);
        this.grey = new Color(0.25,0.25,0.25);
        this.black = new Color(0,0,0);
        this.red = new Color(1,0,0);
        this.green = new Color(0,1,0);
        this.blue = new Color(0,0,1);
        this.yellow = new Color(1,1,0);
        this.darkgrey = new Color(0.1,0.1,0.1);
        
        this.pointLight = new PointLight(new Point3(4, 4, 4), white, false);
        
        this.directionalLight = new DirectionalLight(new Vector3(-1,-1,-1), white, false);
        
        this.spotLight = new SpotLight(new Point3(4,4,4), new Vector3(-1,-1,-1), Math.PI/14, white, false);
        
        this.lightList = new ArrayList<>();
        
        geometryList = new ArrayList();
        
        world = new World(geometryList, lightList, black);
       
    }
    
    /*Sets Camera to Perspective or Orth.*/
    public void setCam(String camera){
        if(camera.equals("perspective Camera")){
            cam = new PerspectiveCamera(new Point3(4, 4, 4), 
                new Vector3(-1, -1, -1),
                new Vector3(0, 1, 0),
                Math.PI/4);
        }else{
            cam = new OrthographicCamera(new Point3(4, 4, 4), new Vector3(-1, -1, -1), new Vector3(0,1,0),3);
        }
        
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
        if(color.equals("darkgrey")){
            return darkgrey;
        }
        
        return null;
    }
    
    private Material getMaterial(Color color, int materialID){
        if(materialID == 0){
            return new LambertMaterial(new SingleColorTexture(color));
        }
        
        if(materialID == 1){
            return new PhongMaterial(new SingleColorTexture(color), new SingleColorTexture(white), 100);
        }
        
        if(materialID == 2){
            return new BlinnPhongMaterial(new SingleColorTexture(color), new SingleColorTexture(white), 64);
        }
        
        if(materialID == 3){
            return new ReflectiveMaterial(new SingleColorTexture(color), new SingleColorTexture(black),64,new SingleColorTexture(grey));
        }
        
        return null;
    }
    
    public void createSphere(Color color, int materialID){
        Sphere sphere = new Sphere(new Point3(-1,1,0), 0.5, getMaterial(color, materialID));
        geometryList.add(sphere);
    }
    
    public void createBox(Color color, int materialID){
        AxisAlignedBox box = new AxisAlignedBox(new Point3(-1.5,0.5,0.5), new Point3(-0.5,1.5,1.5), getMaterial(color, materialID));
        geometryList.add(box);
    }
    
    public void createTriangle(Color color, int materialID){
        Triangle triangle = new Triangle(new Vector3(0, 0, -1), new Vector3(1, 0, -1), new Vector3(1, 1, -1), getMaterial(color, materialID));
        geometryList.add(triangle);
    }
    
    public void createPlane(Color color, int materialID){
        Plane plane = new Plane(new Point3(0,-1,0), new Normal3(0,1,0), getMaterial(color, materialID));
        geometryList.add(plane);
    }
    
    public void drawScene(){
        if(lightList.isEmpty()){
            world.setAmbientColor(white);
        }
        RayTracer rayTracer = new RayTracer(world, cam);
                
    }
}
