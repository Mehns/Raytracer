/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import raytracer.Test1_Geometries;
import raytracer.Test2_Light;
import raytracer.Test3_Shadows;
import raytracer.Test4_ReflectiveMaterial;
import raytracer.Test5_Transformation;
import raytracer.Test6_TransparentMaterial;
import raytracer.Test7_Sampling;
import raytracer.TestTexture;


/**
 *
 * @author sophie
 */
public class RaytracerGUI {
    
    private JFrame frame;
    
    final JMenuBar menu = new JMenuBar();
    
    private JMenu file = new JMenu("Geometries");
    
    private JMenu file2 = new JMenu("Lights");

    private JMenu file3 = new JMenu("Shadow");

    private JMenu file4 = new JMenu("Reflection");

    private JMenu file5 = new JMenu("Transformation");
    
    private JMenu file6 = new JMenu("Transparent");
    
    private JMenu file7 = new JMenu("Sampling");
    
    private JMenu file8 = new JMenu("Texture");
    
    
    public RaytracerGUI(){
        createWindow();
    }
    
    private void createWindow(){
        frame = new JFrame();
        menuBar();
        centerWindow(frame);
        frame.setVisible(true);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (((dimension.getWidth() - frame.getWidth()) / 2) - 400);
        int y = (int) (((dimension.getHeight() - frame.getHeight()) / 2) - 200);
        frame.setLocation(x, y);
    }
    
    private void menuBar(){
        
        newScene();
        
        test1Menu();
        
        test2Menu();
        
        test3Menu();
        
        test4Menu();
        
        test5Menu();
        
        test6Menu();
        
        test7Menu();
        
        test8Menu();
        
        frame.setJMenuBar(menu);
        
    }
    
    private void newScene(){
        JButton newSceneButton = new JButton("New Scene");
        newSceneButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                NewScene newScene1 = new NewScene();
                centerWindow(newScene1);
                newScene1.setVisible(true);
                newScene1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        menu.add(newSceneButton);
    }
    
    private void test1Menu(){
        
        JMenuItem start = new JMenuItem("Start all");
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.startAll();
            }
        });
        file.add(start);
        
        JMenuItem plane = new JMenuItem("Show Plane");
        plane.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test1();
            }
        });
        file.add(plane);
        
        JMenuItem sphere = new JMenuItem("Show Sphere");
        sphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test2();
            }
        });
        file.add(sphere);
        
        JMenuItem doubleSphere = new JMenuItem("Spheres with perspective Cam");
        doubleSphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test3();
            }
        });
        file.add(doubleSphere);
        
        JMenuItem otherDoubleSphere = new JMenuItem("Spheres with orthographic Cam");
        otherDoubleSphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test4();
            }
        });
        file.add(otherDoubleSphere);
        
        JMenuItem triangle = new JMenuItem("Show Triangle");
        triangle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test5();
            }
        });
        file.add(triangle);
        
        JMenuItem box = new JMenuItem("Show Box");
        box.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test1_Geometries test = new Test1_Geometries();
                test.test6();
            }
        });
        file.add(box);
        
        menu.add(file);
    }
    
    private void test2Menu(){
        
        JMenuItem start2 = new JMenuItem("Start all");
        start2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.startAll();
            }
        });
        file2.add(start2);
        
        JMenuItem Test_Scene1 = new JMenuItem("Test Scene 1 ");
        Test_Scene1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test1();
            }
        });
        file2.add(Test_Scene1);
        
        JMenuItem Test_Scene2 = new JMenuItem("Test Scene 2 ");
        Test_Scene2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test2();
            }
        });
        file2.add(Test_Scene2);
        
        JMenuItem Test_Scene3 = new JMenuItem("Test Scene 3 ");
        Test_Scene3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test3();
            }
        });
        file2.add(Test_Scene3);
        
        JMenuItem Test_Scene4 = new JMenuItem("Test Scene 4 ");
        Test_Scene4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test4();
            }
        });
        file2.add(Test_Scene4);
        
        JMenuItem Test_Scene5 = new JMenuItem("Test Scene 5 ");
        Test_Scene5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test5();
            }
        });
        file2.add(Test_Scene5);
        
        JMenuItem Test_Scene6 = new JMenuItem("Test Scene 6 ");
        Test_Scene6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test6();
            }
        });
        file2.add(Test_Scene6);
        
        JMenuItem Test_Scene7 = new JMenuItem("Test Scene 7 ");
        Test_Scene7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test7();
            }
        });
        file2.add(Test_Scene7);
        
        JMenuItem Test_Scene8 = new JMenuItem("Test Scene 8 ");
        Test_Scene8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test2_Light test = new Test2_Light();
                test.test8();
            }
        });
        file2.add(Test_Scene8);
        
        menu.add(file2);
    }
    
    private void test3Menu(){
        
        JMenuItem start3 = new JMenuItem("Start all");
        start3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test3_Shadows test = new Test3_Shadows();
            }
        });
        file3.add(start3);
        menu.add(file3);
        
    }
    
    private void test4Menu(){
        
        JMenuItem start4 = new JMenuItem("Start all");
        start4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test4_ReflectiveMaterial test = new Test4_ReflectiveMaterial();
            }
        });
        file4.add(start4);
        menu.add(file4);
    }
    
    private void test5Menu(){
        
        JMenuItem start5 = new JMenuItem("Start all");
        start5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test5_Transformation test = new Test5_Transformation();
                test.startAll();
            }
        });
        file5.add(start5);
        
        JMenuItem sphere = new JMenuItem("Show Sphere");
        sphere.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test5_Transformation test = new Test5_Transformation();
                test.sphere();
            }
        });
        file5.add(sphere);
        
        JMenuItem box = new JMenuItem("Show Box");
        box.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test5_Transformation test = new Test5_Transformation();
                test.box();
            }
        });
        file5.add(box);
        
        menu.add(file5);
    }
    
    private void test6Menu(){
        
        JMenuItem start6 = new JMenuItem("Start all");
        start6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test6_TransparentMaterial test = new Test6_TransparentMaterial();
            }
        });
        file6.add(start6);
        menu.add(file6);
        
    }
    
    private void test7Menu(){
        
        JMenuItem start7 = new JMenuItem("Start all");
        start7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Test7_Sampling test = new Test7_Sampling();
            }
        });
        file7.add(start7);
        menu.add(file7);
        
    }
    
    private void test8Menu(){
        
        JMenuItem start8 = new JMenuItem("Start all");
        start8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TestTexture test = new TestTexture();
            }
        });
        file8.add(start8);
        menu.add(file8);
        
    }
    
    /**
     * main method, starts the ImageSaver
     * @param args array of arguments
     */
    public static void main(String args[]){
        new RaytracerGUI();              
    }
}
