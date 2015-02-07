package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.Plane;
import geometry.Sphere;
import java.util.ArrayList;
import light.Light;
import light.PointLight;
import material.BlinnPhongMaterial;
import material.LambertMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import texture.ImageTexture;
import texture.SingleColorTexture;
import world.World;

/**
 *
 * @author Christian Mehns
 */
public class TestTexture {
    
    //Test1
    public static void test1(){
        
        // color-texture
        SingleColorTexture redTexture = new SingleColorTexture(new Color(1,0,0));
        SingleColorTexture whiteTexture = new SingleColorTexture(new Color(1,1,1));  
        
        // image texture
        ImageTexture earthTexture = new ImageTexture("earth.jpg");
        
        BlinnPhongMaterial redMat = new BlinnPhongMaterial(redTexture, whiteTexture, 64);
        BlinnPhongMaterial imageMat = new BlinnPhongMaterial(earthTexture, redTexture, 64);
        LambertMaterial imageLamb = new LambertMaterial(earthTexture);
        
        
        
        Sphere sphere = new Sphere(new Point3(0,0,-6), 1, imageLamb);
        
        ArrayList geoList1 = new ArrayList();
        geoList1.add(sphere);
        
        PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,0), new Vector3(0,0,-1), new Vector3(0,1,0),Math.PI/4);
        
        // lights
        PointLight light01 = new PointLight(new Point3(4, 4, 4), new Color(1,1,1), true);
        ArrayList<Light> lightList1 = new ArrayList<>();
        lightList1.add(light01);
        
        //world
        World world1 = new World(geoList1, lightList1, new Color(0,0,0));
        
        RayTracer rayTracer1 = new RayTracer(world1, cam1);
    }
    
    public static void main(String[] args) {
        test1();
    }
    
    
}
