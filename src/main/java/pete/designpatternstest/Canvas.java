/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author peter
 */

public class Canvas extends JPanel{
    
    private BufferedImage blueImage;
    private Sprite bluePlane;
    
    public Canvas(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        blueImage = loadImage("images/blue_plane.png");
        bluePlane = new BluePlane(120,250,blueImage);        
    
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP){
                    bluePlane.move(0, -6);
                }else if(keyCode == KeyEvent.VK_DOWN){
                    bluePlane.move(0, 6);
                }else if(keyCode == KeyEvent.VK_RIGHT){
                    bluePlane.move(6, 0);
                }else if(keyCode == KeyEvent.VK_LEFT){
                    bluePlane.move(-6, 0);
                }
                Canvas.this.repaint();
            }
        });
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bluePlane.draw(g);
    }
    
    public BufferedImage loadImage(String imagePath){
        File file = new File(imagePath);
        BufferedImage bufferedImage = null;
        try{
            bufferedImage = ImageIO.read(file);
        }catch(IOException e){
            e.printStackTrace();
        }
        return bufferedImage;
    }
    
}
