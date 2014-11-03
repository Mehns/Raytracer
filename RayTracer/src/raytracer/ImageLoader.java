
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
 * @author Isch
 */
public class ImageLoader extends JFrame{
    public ImageLoader(){       
        
        BufferedImage image = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "jpeg", "png");        
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        
        int returnValue = chooser.showOpenDialog(null);      
                
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            this.setTitle(chooser.getName(file));
            
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }        
        
        ImageIcon icon = new ImageIcon(image);        
        JLabel label = new JLabel(icon);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(icon.getIconWidth(), icon.getIconHeight());
        getContentPane().add(label);
        pack();
        setVisible(true);        
    }    

    public static void main(String args[])
    {
        new ImageLoader();        
    }   
}
