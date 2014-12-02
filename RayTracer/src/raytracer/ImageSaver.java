
package raytracer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 * 
 * @author Christian Mehns
 */
public class ImageSaver extends JFrame implements ActionListener {
    private final int WINDOW_WIDTH = 640;
    private final int WINDOW_HEIGHT = 480;
    
    private final ImageCanvas imageCanvas;
         
    /**
     * creates a JFrame that draws a red line on black background 
     * with a menu to save the picture
     */
    public ImageSaver() {
        super("Image Saver");
        
        // prepares window
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // adds menu with save button
        final JMenuBar menu = new JMenuBar();
        final JMenu file = new JMenu("File");
        final JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        file.add(saveItem);
        menu.add(file);
        this.setJMenuBar(menu);
        
        // adds the canvas with the diagonal to this window and shows it
        this.imageCanvas = new ImageCanvas(null, null);        
        this.add(this.imageCanvas);        
        setVisible(true);        
    }

    @Override
    // opens a dialog to let user save the image, checks if file is jpg or png
    public void actionPerformed(final ActionEvent e) {
        
        if (e.getActionCommand().equals("Save")) {
            
            final JFileChooser fileDialog = new JFileChooser();
            final int returnValue = fileDialog.showSaveDialog(this);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                final File saveFile = fileDialog.getSelectedFile();
                
                String savingImage = saveFile.getName().toLowerCase();
                
                if (savingImage.endsWith("jpg")) {
                    savingImage = "jpg";
                } else if (savingImage.endsWith("png")) {
                    savingImage = "png";
                } else {
                    throw new IllegalArgumentException("Dateiendung muss .jpg oder .png sein");
                }
                
                try {
                    ImageIO.write(this.imageCanvas.image, savingImage, saveFile);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }          
        }
    }
    
    /**
     * main method, starts the ImageSaver
     * @param args array of arguments
     */
    public static void main(String args[]){
        new ImageSaver();              
    }
}