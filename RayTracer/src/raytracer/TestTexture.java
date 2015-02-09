package raytracer;

import camera.PerspectiveCamera;
import color.Color;
import geometry.AxisAlignedBox;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import java.util.ArrayList;
import light.Light;
import light.PointLight;
import material.BlinnPhongMaterial;
import material.LambertMaterial;
import material.PhongMaterial;
import material.SingleColorMaterial;
import mathlibrary.Normal3;
import mathlibrary.Point3;
import mathlibrary.Vector3;
import sampling.SamplingPattern;
import texture.ImageTexture;
import texture.SingleColorTexture;
import texture.TexCoord2;
import world.World;

/**
 *
 * @author Christian Mehns
 */
public class TestTexture {
    
    public TestTexture(){
        test1();
    }
    
    //Test1
    public void test1(){
        
        // color-texture
        SingleColorTexture redTexture = new SingleColorTexture(new Color(1,0,0));
        SingleColorTexture whiteTexture = new SingleColorTexture(new Color(1,1,1));  
        
        // image texture
        ImageTexture earthTexture = new ImageTexture("earth.jpg");
        ImageTexture checkerTexture = new ImageTexture("checker2.jpg");
        
        LambertMaterial imageLamb = new LambertMaterial(earthTexture);
        LambertMaterial checkerLamb = new LambertMaterial(checkerTexture);
        SingleColorMaterial imageSingle = new SingleColorMaterial(redTexture);
        PhongMaterial phongMat = new PhongMaterial(redTexture, whiteTexture, 64);
        
        
        // geometry        
        Sphere sphere = new Sphere(new Point3(0,0,-6), 1, imageLamb);
        Plane plane = new Plane(new Point3(0, -2, 0), new Normal3(0, 1, 0), checkerLamb);
        Triangle triangle = new Triangle(new Vector3(-2,0.5,0), new Vector3(1.3,0.5,-1), new Vector3(0,2,-3), 
                                new TexCoord2(2.0, 2.0), new TexCoord2(5.0, 5.0), new TexCoord2(5.0, 0.0),
                                checkerLamb);
        AxisAlignedBox box = new AxisAlignedBox(new Point3(1,-1,-1),new Point3(2,0,0),checkerLamb);
        
        ArrayList geoList1 = new ArrayList();
        geoList1.add(sphere);
        geoList1.add(plane);
        geoList1.add(triangle);
        geoList1.add(box);
        
        PerspectiveCamera cam1 = new PerspectiveCamera(new Point3(0,0,5), new Vector3(0,0,-1), new Vector3(0,1,0), new SamplingPattern(1,1), Math.PI/4);
        
        // lights
        PointLight light01 = new PointLight(new Point3(4, 4, 4), new Color(1,1,1), true);
        ArrayList<Light> lightList1 = new ArrayList<>();
        lightList1.add(light01);
        
        //world
        World world1 = new World(geoList1, lightList1, new Color(0.1,0.1,0.1));
        
        RayTracer rayTracer1 = new RayTracer(world1, cam1);
    }
    
    
    
}
