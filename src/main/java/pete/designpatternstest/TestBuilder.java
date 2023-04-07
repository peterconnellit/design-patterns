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
public class TestBuilder {
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Design Pattern Builder");
        
        SelectDialog.Builder builder = new SelectDialog.Builder();
        builder.setTitle("Please Select Plane");
        
        SelectDialog dialog = builder.create();
        dialog.showDialog();
        
        frame.setSize(300, 350);
        frame.setVisible(true);
    }
    
}
