/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import camera.Camera;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import world.World;

/**
 *
 * @author Christian
 */
public class RayTracer extends JFrame{

    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;
    ImageCanvas imageCanvas;
    
    public RayTracer(World world, Camera cam){
        super("Ray Tracer");
        
        this.setSize(640, 480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.imageCanvas = new ImageCanvas(world, cam); 
        add(this.imageCanvas);     
        setVisible(true); 
    }
    
    public void draw(World world, Camera cam){
        for (int w = 0; w < WINDOW_WIDTH; w++) {
            for (int h = 0; h < WINDOW_HEIGHT; h++) {
                Ray ray = cam.rayFor(WINDOW_WIDTH, WINDOW_HEIGHT, w, h);
                world.hit(ray);
            }
        }
    }
    

}
