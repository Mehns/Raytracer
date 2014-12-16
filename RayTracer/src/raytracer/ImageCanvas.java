
package raytracer;

import camera.Camera;
import java.awt.Canvas;
import color.Color;
import geometry.Geometry;
import geometry.Hit;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Objects;
import world.World;

/**
 * Canvas that draws world with geometry from camera perspective
 * @author Chrstian Mehns
 */
public class ImageCanvas extends Canvas {
    
    /**
     * data of our image
     */
    public BufferedImage image;
    
    /**
     * world for image
     */
    public final World world; 
    
    /**
     * camera for image
     */
    public final Camera cam;
    
    /**
     * width of image
     */
    public final int imageWidth;
    
    /**
     * height of image
     */
    public final int imageHeight;

    
    /**
     * constructs new ImageCanvas
     * @param world for image
     * @param cam for image
     */
    public ImageCanvas(final World world, final Camera cam){
        this.world = world;
        this.cam = cam;
        
        imageWidth = RayTracer.WINDOW_WIDTH;
        imageHeight = RayTracer.WINDOW_HEIGHT;

    }
    
    @Override
    public void paint (final Graphics graphic){
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
                    color = hit.geo.material.colorFor(hit,world);
                }

                java.awt.Color convertColor = new java.awt.Color((float)color.r, 
                                                               (float)color.g, 
                                                               (float)color.b);
                
                raster.setDataElements(x, image.getHeight() -1 - y, colorModel.getDataElements(convertColor.getRGB(), null));
                                
            }
        }

        graphic.drawImage(image, 0, 0, this);        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.image);
        hash = 29 * hash + Objects.hashCode(this.world);
        hash = 29 * hash + Objects.hashCode(this.cam);
        hash = 29 * hash + this.imageWidth;
        hash = 29 * hash + this.imageHeight;
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
        final ImageCanvas other = (ImageCanvas) obj;
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.world, other.world)) {
            return false;
        }
        if (!Objects.equals(this.cam, other.cam)) {
            return false;
        }
        if (this.imageWidth != other.imageWidth) {
            return false;
        }
        if (this.imageHeight != other.imageHeight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImageCanvas{" + "image=" + image + ", world=" + world + ", cam=" + cam + ", imageWidth=" + imageWidth + ", imageHeight=" + imageHeight + '}';
    }

}
