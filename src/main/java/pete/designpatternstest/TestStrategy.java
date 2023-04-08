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
public class TestStrategy {
    
    public static void main(String[] args){

        CGlobal.frame = new JFrame("Design Pattern Strategy");

        SelectBulletDialog.Builder builder = new SelectBulletDialog.Builder();
        builder.setTitle("Please Select Bullet");

        SelectBulletDialog dialog = builder.create();
        dialog.showDialog();

        CGlobal.frame.setSize(300, 350);
        CGlobal.frame.setVisible(true);
        
    }
    
}
