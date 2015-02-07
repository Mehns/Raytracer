package texture;

import color.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 * This class represents a texture made of an image
 * @author Christian Mehns
 */
public class ImageTexture implements Texture{
          
    /**
     * image that is used as texture
     */
    public BufferedImage image;
    
    private final String rootPath = "src/texture/";

    /**
     * Constructor
     * constructs an imagetexture from a given image
     * @param imagePath path to image
     */
    public ImageTexture(String imagePath) {
        this.image = null;
        
        try {
            this.image = ImageIO.read(new File(rootPath+imagePath));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            
        }
    }
    
    

    @Override
    public Color getColor(double u, double v) {
        final double uCoordinate = getRelativeCoordinate(u);
        final double vCoordinate = getRelativeCoordinate(v);
        final double x = (this.image.getWidth() - 1) * uCoordinate;
        final double y = (this.image.getHeight() - 1) - 
                ((this.image.getHeight() - 1) * vCoordinate); //left bottom origin
        
        final int xInt = (int) Math.round(x);
        final int yInt = (int) Math.round(y);
        
        return getPositionColor(this.image, xInt, yInt);
    }
    
    /**
     * calculates the relative Coordinate on the image by given texture-coordinate
     * @param coordinateIn texture coordinate to be transformed
     * @return image-coordinate
     */
    public static double getRelativeCoordinate(final double coordinateIn){
        double coordinateOut = coordinateIn % 1.0;
                
        if (coordinateOut < 0.0) {
            coordinateOut += 1.0;            
        }
        
        return coordinateOut;                
    }
    
    /**
     * Returns the Color of a certain position on an given image
     * @param image provided image
     * @param x x-Coordinate on image
     * @param y y-Coordinate on image
     * @return
     */
    public static Color getPositionColor(final BufferedImage image, final int x, final int y){
        final java.awt.Color color = new java.awt.Color(image.getRGB(x, y));
        final double r = color.getRed();
        final double g = color.getGreen();
        final double b = color.getBlue();
        return new Color(r, g, b);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.image);
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
        final ImageTexture other = (ImageTexture) obj;
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImageTexture{" + "image=" + image + '}';
    }
}
