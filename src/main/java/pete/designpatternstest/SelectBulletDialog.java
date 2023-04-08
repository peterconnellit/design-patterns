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
public class SelectBulletDialog extends JDialog{
    
    private JButton blueBulletButton;
    private JButton redBulletButton;
    private JButton yellowBulletButton;
    
    private SelectBulletDialog(){
        this.setModal(true);
        this.setBackground(Color.WHITE);
        this.setSize(300, 150);
        this.setLayout(new FlowLayout());
        
        blueBulletButton = new JButton();
        blueBulletButton.setIcon(new ImageIcon("images/blue_bullet.png"));
        blueBulletButton.setBackground(Color.WHITE);
        blueBulletButton.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e){
                Canvas canvas = new Canvas("1");
                SelectBulletDialog.this.dispose();
                CGlobal.frame.repaint();
                CGlobal.frame.add(canvas, BorderLayout.CENTER);
                canvas.setFocusable(true);
                canvas.requestFocus();
            }
        });
        
        redBulletButton = new JButton();
        redBulletButton.setIcon(new ImageIcon("images/red_bullet.png"));
        redBulletButton.setBackground(Color.WHITE);
        redBulletButton.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e){
                Canvas canvas = new Canvas("2");
                SelectBulletDialog.this.dispose();
                CGlobal.frame.repaint();
                CGlobal.frame.add(canvas, BorderLayout.CENTER);
                canvas.setFocusable(true);
                canvas.requestFocus();
            }
        });
        
        yellowBulletButton = new JButton();
        yellowBulletButton.setIcon(new ImageIcon("images/yellow_bullet.png"));
        yellowBulletButton.setBackground(Color.WHITE);
        yellowBulletButton.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent e){
                Canvas canvas = new Canvas("3");
                SelectBulletDialog.this.dispose();
                CGlobal.frame.repaint();
                CGlobal.frame.add(canvas, BorderLayout.CENTER);
                canvas.setFocusable(true);
                canvas.requestFocus();
            }
        });
        
        this.add(blueBulletButton);
        this.add(redBulletButton);
        this.add(yellowBulletButton);        
    }
    
    public void showDialog(){
        this.setVisible(true);
    }
    
    public static class Builder{
        private SelectBulletDialog dialog;
        
        public Builder(){
            dialog = new SelectBulletDialog();
        }
        
        public void setTitle(String title){
            dialog.setTitle(title);
        }
        
        public SelectBulletDialog create(){
            return dialog;
        }        
    }    
}
