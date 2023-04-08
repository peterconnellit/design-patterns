/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author peter
 */
public class TestBridge {
    
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Design Pattern Bridge");
        Canvas canvas = new Canvas();
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(300, 350);
        canvas.setFocusable(true);
        frame.setVisible(true);
        canvas.requestFocus();        
    }    
}
