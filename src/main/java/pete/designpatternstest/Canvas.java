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
    private Plane plane;
    private BulletProps bulletProps;
    private int canvasWidth;
    private int canvasHeight;
    
    static{ 
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
        ImageCache.put("blueDecoratorImage", ImageUtil.loadImage("images/explosion.png"));        
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        bulletProps = new BulletProps(120, 0);
        bulletProps.setVisible(true);
                
        plane = new BluePlane(120, 250);
        plane.setVisible(true);
    
        new Thread(this).start();
        
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();                   
                if(keyCode == KeyEvent.VK_UP){
                    plane.move(0, -12);
                }else if(keyCode == KeyEvent.VK_DOWN){
                    plane.move(0, 12);
                }else if(keyCode == KeyEvent.VK_RIGHT){
                    plane.move(12, 0);
                }else if(keyCode == KeyEvent.VK_LEFT){
                    plane.move(-12, 0);
                }             
            }
        });       
    }
    
    protected void paintComponent(Graphics g){
        this.canvasWidth = this.getWidth();
        this.canvasHeight = this.getHeight();
        super.paintComponent(g);
        plane.draw(g);
        plane.drawBullets(g);
        bulletProps.draw(g);
    }
    
    private void collideCheck(){
        if(plane.collideWith(bulletProps)){
            bulletProps.setVisible(false);
            plane = new PlaneDecorator(plane, this.canvasHeight);
            plane.setVisible(true);
        }
    }

    public void run(){
        while(isRun){
            try{
                plane.createBullets();
                plane.moveBullet(0, -3);
                bulletProps.move(0, 3);
                collideCheck();
                Thread.sleep(200);
                Canvas.this.repaint();                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }  
}
