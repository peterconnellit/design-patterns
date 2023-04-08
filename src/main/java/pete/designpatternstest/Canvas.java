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
    private BufferedImage blueImage;
    private BluePlane bluePlane;
    
    static{
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
        ImageCache.put("blueBulletImage", ImageUtil.loadImage("images/blue_bullet.png"));
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("yellowBulletImage", ImageUtil.loadImage("images/yellow_bullet.png"));        
    }
    
    public Canvas(String bulletType){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        bluePlane = new BluePlane(120, 250);
        if("1".equals(bulletType)){
            Bullet bullet = new BlueBullet(-100, -100);
            bluePlane.loadBullet(bullet);            
        }else if("2".equals(bulletType)){
            Bullet bullet = new RedBullet(-100, -100);
            bluePlane.loadBullet(bullet);
        }else if("3".equals(bulletType)){
            Bullet bullet = new YellowBullet(-100, -100);
            bluePlane.loadBullet(bullet);
        }
    
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
                }else if(keyCode == KeyEvent.VK_ENTER){
                    bluePlane.fireBullet();
                }
            }
        });       
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);
    }
    
    public void bulletMove(){
        if (bluePlane.getBullet().isVisible()){
            bluePlane.getBullet().move(0, -3);
        }
    }
    
    public void run(){
        while(isRun){
            try{
                bulletMove();
                Thread.sleep(50);
                Canvas.this.repaint();                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
