/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import GUI.RaytracerGUI;
import camera.Camera;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import world.World;

/**
 * represents a raytracer
 * @author Christian
 */
public class RayTracer extends JFrame{

    /**
     * width of window
     */
    public static final int WINDOW_WIDTH = 640;
    
    /**
     * height of window
     */
    public static final int WINDOW_HEIGHT = 480;
    
    /**
     * imageCanvas of RayTracer
     */
    private final ImageCanvas imageCanvas;
    
    /**
     * constructs a RayTracer
     * @param world of RayTracer
     * @param cam of RayTracer
     */
    public RayTracer(final World world, final Camera cam){
        super("Ray Tracer");
        
        this.setSize(640, 480);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        this.imageCanvas = new ImageCanvas(world, cam); 
        add(this.imageCanvas);
        setVisible(true); 
    }
    
//    /**
//     * creates a ray for every pixel in Frame and looks for hits
//     * @param world stores geometries
//     * @param cam for ray
//     */
//    public void draw(final World world, final Camera cam){
//        for (int w = 0; w < WINDOW_WIDTH; w++) {
//            for (int h = 0; h < WINDOW_HEIGHT; h++) {
//                Ray ray = cam.rayFor(WINDOW_WIDTH, WINDOW_HEIGHT, w, h);
//                world.hit(ray);
//            }
//        }
//    }

    public static void main(String[] args){
        //Test7_Sampling test7 = new Test7_Sampling();
        new RaytracerGUI();
    }
    
    @Override
    public String toString() {
        return "RayTracer{" + "imageCanvas=" + imageCanvas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.imageCanvas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RayTracer other = (RayTracer) obj;
        if (!Objects.equals(this.imageCanvas, other.imageCanvas)) {
            return false;
        }
        return true;
    }

}
