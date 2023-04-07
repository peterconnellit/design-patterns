/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.event.*;
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
        bluePlaneButton.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e){
                Canvas canvas = new Canvas("1");
                SelectDialog.this.dispose();
                CGlobal.frame.repaint();
                CGlobal.frame.add(canvas, BorderLayout.CENTER);
                canvas.setFocusable(true);
                canvas.requestFocus();
            }
        });
        
        redPlaneButton = new JButton();
        redPlaneButton.setIcon(new ImageIcon("images/red_plane.png"));
        redPlaneButton.setBackground(Color.WHITE);
        redPlaneButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Canvas canvas = new Canvas("2");
                SelectDialog.this.dispose();
                CGlobal.frame.repaint();
                CGlobal.frame.add(canvas, BorderLayout.CENTER);
                canvas.setFocusable(true);
                canvas.requestFocus();
            }
        });
        
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
