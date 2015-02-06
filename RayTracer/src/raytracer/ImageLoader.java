
package raytracer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Christian Mehns
 */
public class ImageLoader extends JFrame{
    
    /**
     * creates a JFrame and loads a user-selected image
     */
    public ImageLoader(){       
        
        
        BufferedImage image = null;
        
        // FileChooser with Filter for jpg, png
        final JFileChooser chooser = new JFileChooser();
        final FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "jpeg", "png");        
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        
        // loads Image if user has chosen the right format
        final int returnValue = chooser.showOpenDialog(null);            
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            final File file = chooser.getSelectedFile();
            this.setTitle(chooser.getName(file) + "1");
            
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }        
        
        // fills the window with the image
        final ImageIcon icon = new ImageIcon(image);        
        final JLabel label = new JLabel(icon);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        getContentPane().add(label);
        pack();
        setVisible(true);        
    }    

    /**
     * main method, starts the ImageLoader
     * @param args array of arguments
     */
    public static void main(String args[])
    {
        new ImageLoader();        
    }   
}
