/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author peter
 */
public class SelectDialog extends JDialog{
    private JButton bluePlaneButton;
    private JButton redPlaneButton;
    
    private SelectDialog(){
        this.setModal(true);
        this.setBackground(Color.WHITE);
        this.setSize(300, 150);
        this.setLayout(new FlowLayout());
        bluePlaneButton = new JButton();
        bluePlaneButton.setIcon(new ImageIcon("images/blue_plane.png"));
        bluePlaneButton.setBackground(Color.WHITE);
        
        redPlaneButton = new JButton();
        redPlaneButton.setIcon(new ImageIcon("images/red_plane.png"));
        redPlaneButton.setBackground(Color.WHITE);
        
        this.add(bluePlaneButton);
        this.add(redPlaneButton);
    }
    
    public void showDialog(){
        this.setVisible(true);
    }
    
    public static class Builder {
        private SelectDialog dialog;
        public Builder(){
            dialog = new SelectDialog();
        }
        
        public void setTitle(String title){
            dialog.setTitle(title);
        }
        
        public SelectDialog create(){
            return dialog;
        }
    }
    
}
