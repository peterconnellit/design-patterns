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

public class Canvas extends JPanel implements Runnable{
    
    private boolean isRun = true;
    private BluePlane bluePlane;
    
    static{
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));        
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        bluePlane = new BluePlane(120, 250);        
    
        new Thread(this).start();
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();                   
                if(keyCode == KeyEvent.VK_UP){
                    bluePlane.move(0, -3);
                }else if(keyCode == KeyEvent.VK_DOWN){
                    bluePlane.move(0, 3);
                }else if(keyCode == KeyEvent.VK_RIGHT){
                    bluePlane.move(3, 0);
                }else if(keyCode == KeyEvent.VK_LEFT){
                    bluePlane.move(-3, 0);
                }                
                Canvas.this.repaint();
            }
        });       
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bluePlane.draw(g);
        bluePlane.drawBullets(g);        
    }  

    @Override
    public void run(){
        while(isRun){
            try{
                bluePlane.createBullets();
                bluePlane.moveBullets(0, -3);
                Thread.sleep(50);
                Canvas.this.repaint();                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }  
}
