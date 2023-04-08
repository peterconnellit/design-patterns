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
    private Plane bluePlane;
    private Plane redPlane;
    
    static{
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
        ImageCache.put("redPlaneImage", ImageUtil.loadImage("images/red_plane.png"));
        ImageCache.put("blueBulletImage", ImageUtil.loadImage("images/blue_bullet.png"));
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));        
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        redPlane = new RedPlane(80, 250);
        redPlane.loadBullet(new RedBullet(-100, -100));
        
        bluePlane = new BluePlane(160, 250);
        bluePlane.loadBullet(new BlueBullet(-100, -100));
    
        new Thread(this).start();
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_E){
                    redPlane.move(0, -3);
                }else if(keyCode == KeyEvent.VK_D){
                    redPlane.move(0, 3);
                }else if(keyCode == KeyEvent.VK_F){
                    redPlane.move(3, 0);
                }else if(keyCode == KeyEvent.VK_S){
                    redPlane.move(-3, 0);
                }else if(keyCode == KeyEvent.VK_G){
                    redPlane.fireBullet();
                }
                   
                if(keyCode == KeyEvent.VK_UP){
                    bluePlane.move(0, -3);
                }else if(keyCode == KeyEvent.VK_DOWN){
                    bluePlane.move(0, 3);
                }else if(keyCode == KeyEvent.VK_RIGHT){
                    bluePlane.move(3, 0);
                }else if(keyCode == KeyEvent.VK_LEFT){
                    bluePlane.move(-3, 0);
                }else if(keyCode == KeyEvent.VK_ENTER){
                    bluePlane.fireBullet();
                }
                Canvas.this.repaint();
            }
        });       
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);
        redPlane.draw(g);
        redPlane.getBullet().draw(g);
        
    }
    
    public void bulletMove(){
        if (bluePlane.getBullet().isVisible()){
            bluePlane.getBullet().move(0, -3);
        }
        
        if (redPlane.getBullet().isVisible()){
            redPlane.getBullet().move(0, -3);
        }
    }
    
    @Override
    public void run(){
        while(isRun){
            try{
                bulletMove();
                Thread.sleep(200);
                Canvas.this.repaint();                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }  
}
