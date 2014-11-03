/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlibrary;

/**
 * This class tests methods from:
 * Mat3x3, 
 * Normal3, 
 * Vector3 and 
 * Point3
 * @author Lena
 */
public class Test {
    /**
     * normal parameters that where given in task
     */
    static final Normal3 n1 = new Normal3(1,2,3); 
    static final Normal3 n2 = new Normal3(3,2,1);
    static final Normal3 n3 = new Normal3(1,0,0);
    static final Normal3 n4 = new Normal3(0,1,0);
    static final Normal3 n5 = new Normal3(2,2,0);
    
    /**
     * vector parameters that where given in task
     */      
    static final Vector3 v1 = new Vector3(1,0,0);
    static final Vector3 v2 = new Vector3(0,1,0);
    static final Vector3 v3 = new Vector3(4,3,2);
    static final Vector3 v4 = new Vector3(1,1,1);
    static final Vector3 v5 = new Vector3(8,8,8);
    static final Vector3 v6 = new Vector3(3,2,1);
    static final Vector3 v7 = new Vector3(-0.707,0.707,0);
    static final Vector3 v8 = new Vector3(0.707,0.707,0);
    static final Vector3 v9 = new Vector3(1,2,3);
    static final Vector3 v10 = new Vector3(3,2,1);
    
    /**
     * point parameters that where given in task
     */    
    static final Point3 p1 = new Point3(1,1,1);
    static final Point3 p2 = new Point3(2,2,0);
    static final Point3 p3 = new Point3(3,2,1);
    
    /**
     * 3x3 matrix parameters that where given in task
     */    
    static final Mat3x3 m1 = new Mat3x3(1,0,0,
                                        0,1,0,
                                        0,0,1);
    static final Mat3x3 m2 = new Mat3x3(1,2,3,
                                        4,5,6,
                                        7,8,9);
    static final Mat3x3 m3 = new Mat3x3(0,0,1,
                                        0,1,0,
                                        1,0,0);
    
    /**
     * main method tests methods from: 
     * Mat3x3, 
     * Normal3, 
     * Vector3 and 
     * Point3
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("START-----------------------------------------------------------------------------");
        System.out.println("task 1: \ntest Normal3 mul(double n): " + n1 + "* 0.5 = " + n1.mul(0.5));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 2: \ntest Normal3 add(Normal3 n): " + n1 + " + " + n2 + " = " + n1.add(n2));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("Skalarprodukt Normale und Vektor");
        System.out.println("task 3.1.1: \ntest Normal3 dot(Vector3 v): " + n3 + " * " + v1 + " = " + n3.dot(v1));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("task 3.1.2: \ntest Normal3 dot(Vector3 v): " + n3 + " * " + v2 + " = " + n3.dot(v2));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("Skalarprodukt Vektor und Normale");
        System.out.println("task 3.2.1: \ntest Vector3 dot(Normal3 v): " + v1 + " * " + n3 + " = " + v1.dot(n3));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("task 3.2.2: \ntest Vector3 dot(Normal3 v): " + v1 + " * " + n4 + " = " + v1.dot(n4));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("Skalarprodukt Vektor und Vektor");
        System.out.println("task 3.3.1: \ntest Vector3 dot(Vector3 v): " + v1 + " * " + v1 + " = " + v1.dot(v1));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("task 3.3.2: \ntest Vector3 dot(Vector3 v): " + v1 + " * " + v2 + " = " + v1.dot(v2));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 4: \ntest Point3 sub(Point3 p): " + p1 + " - " + p2 + " = " + p1.sub(p2));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 5: \ntest Point3 sub(Vector3 v): " + p1 + " - " + v3 + " = " + p1.sub(v3));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 6: \ntest Point3 add(Vector3 v): " + p1 + " + " + v3 + " = " + p1.add(v3));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 7: \ntest magnitude Vector3: magnitude of " + v4 + " = " + v4.magnitude);
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("test Vector3");
        System.out.println("task 8.1: \ntest Vector3 add(Vector3 v): " + v9 + " + " + v10 + " = " + v9.add(v10));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 8.2: \ntest Vector3 add(Normal3 n): " + v9 + " + " + n2 + " = " + v9.add(n2));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 8.3: \ntest Vector3 sub(Normal3 n): " + v4 + " - " + n5 + " = " + v4.sub(n5));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 8.4: \ntest Vector3 mul(double c): " + v9 + " * " + 0.5 + " = " + v9.mul(0.5));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 9: \ntest reflection1: " + v7 + " reflectedOn " + n4 + " = " + v7.reflectedOn(n4));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 10: \ntest reflection2: " + v8 + " reflectedOn " + n3 + " = " + v8.reflectedOn(n3));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("Punkt:");
        System.out.println("task 11.1: \ntest Mat3x3 mul(Mat3x3 m): " + m1 + " * " + p3 + " = " + m1.mul(p3));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("Vektor:");
        System.out.println("task 11.2: \ntest Mat3x3 mul(Mat3x3 m): " + m1 + " * " + v6 + " = " + m1.mul(v6));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 12: \ntest Mat3x3 mul(Mat3x3 m): " + m2 + " * " + m1 + " = " + m2.mul(m1));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 13: \ntest Mat3x3 mul(Mat3x3 m): " + m2 + " * " + m3 + " = " + m2.mul(m3));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 14.1: \ntest Mat3x3 changeCol1(Vector3 v): " + m2 + " changeCol1 " + v5 + " = " + m2.changeCol1(v5));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 14.2: \ntest Mat3x3 changeCol2(Vector3 v): " + m2 + " changeCol1 " + v5 + " = " + m2.changeCol2(v5));
        System.out.println("-----------------------------------------------------------------------------");
        
        System.out.println("task 14.3: \ntest Mat3x3 changeCol3(Vector3 v): " + m2 + " changeCol1 " + v5 + " = " + m2.changeCol3(v5));
        System.out.println("END-----------------------------------------------------------------------------");
    }    
}
