
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
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    
    private ImageCanvas imageCanvas;
         
    
    public ImageSaver() {
        super("Image Saver");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        file.add(saveItem);
        menu.add(file);
        this.setJMenuBar(menu);
        
        this.imageCanvas = new ImageCanvas();
        
        this.add(this.imageCanvas);
        
        setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Save")) {
            
            JFileChooser fileDialog = new JFileChooser();
            int returnValue = fileDialog.showSaveDialog(this);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileDialog.getSelectedFile();
                
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
    
    
    public static void main(String args[]){
        new ImageSaver();              
    }
}
