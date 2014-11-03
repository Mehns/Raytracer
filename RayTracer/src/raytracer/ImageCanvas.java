
package raytracer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import static java.awt.image.ImageObserver.WIDTH;
import java.awt.image.WritableRaster;

/**
 *
 * @author Chrstian Mehns
 */
public class ImageCanvas extends Canvas {
    public BufferedImage image;
    
    @Override
    public void paint (final Graphics graphic){
        super.paint(graphic);
        this.image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        final WritableRaster raster = image.getRaster();
        final ColorModel colorModel = image.getColorModel();
        
        final int black = Color.black.getRGB();
        final int red = Color.red.getRGB();
        
        
        graphic.drawImage(image, WIDTH, WIDTH, this);
        
        raster.setDataElements(0, 0, 1, 1, colorModel.getDataElements(black, null));
        
        for (int w = 0; w < image.getWidth(); w++) {
            for (int h = 0; h < image.getHeight(); h++) {
                if (w == h) {
                raster.setDataElements(w, h, colorModel.getDataElements(red, null));
                }   
            }
        }
        graphic.drawImage(image, 0, 0, Color.BLACK, this);        
    }
}
