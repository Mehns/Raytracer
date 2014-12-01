
package raytracer;

import camera.Camera;
import java.awt.Canvas;
import color.Color;
import geometry.Hit;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import static java.awt.image.ImageObserver.WIDTH;
import java.awt.image.WritableRaster;
import world.World;

/**
 * Canvas that draws a red diagonal line on black background
 * @author Chrstian Mehns
 */


public class ImageCanvas extends Canvas {
    public BufferedImage image;
    World world; 
    Camera cam;
    
    public int imageWidth;
    public int imageHeight;

    
    
    public ImageCanvas(World world, Camera cam){
        this.world = world;
        this.cam = cam;
        
        imageWidth = RayTracer.WINDOW_WIDTH;
        imageHeight = RayTracer.WINDOW_HEIGHT;

    }
    
    @Override
    public void paint (final Graphics graphic){
        System.out.println("paint my picture");
        this.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        final WritableRaster raster = image.getRaster();
        final ColorModel colorModel = image.getColorModel();
        
        
        Color backColor = world.backgroundColor;
        
        // draw 
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                
                Ray ray = cam.rayFor(image.getWidth(), image.getHeight(), x, y);
                Hit hit = world.hit(ray);
                
                Color color;
                
                
                if (hit == null || hit.geo == null) {
                    color = backColor;
                } else {
                    color = hit.geo.color;
                }

                java.awt.Color convertColor = new java.awt.Color((float)color.r, 
                                                               (float)color.g, 
                                                               (float)color.b);
                
                double[] colorChannel = {color.r, color.g, color.b};
                
                raster.setDataElements(x, image.getHeight() -1 - y, colorModel.getDataElements(convertColor.getRGB(), null));
                                
            }
        }

        graphic.drawImage(image, 0, 0, this);        
    }

}
