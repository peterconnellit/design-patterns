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
    private EnemyPlane enemyPlane;
    private int canvasWidth;
    private int canvasHeight;
    private boolean isInit = false;
    private Mediator mediator;
      
    static{ 
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("enemyPlaneImage", ImageUtil.loadImage("images/enemy_plane.png")); 
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane1.png")); 
        ImageCache.put("explosionImage", ImageUtil.loadImage("images/explosion.png")); 
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }
    
    private void init(){
        enemyPlane = new EnemyPlane(120, 0);
        enemyPlane.setVisible(true);
        
        bluePlane = new BluePlane(0, 0);
        bluePlane.setX(this.canvasWidth/2 - bluePlane.getWidth()/2);
        bluePlane.setY(this.canvasHeight - bluePlane.getHeight()-30);
        bluePlane.loadBullet(new RedBullet(-100, -100));
        bluePlane.setVisible(true);
        mediator = new MediatorImpl();
        
        new Thread(this).start();
        
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
                }else if(keyCode == KeyEvent.VK_ENTER){
                    bluePlane.fireBullet();
                }
            }
        });          
    }  
      
    protected void paintComponent(Graphics g){
        this.canvasWidth = this.getWidth();
        this.canvasHeight = this.getHeight();
        
        if(!isInit){
            init();
            isInit = true;
        }     
        super.paintComponent(g);
        collideCheck(g);
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);
        enemyPlane.draw(g);
    }
    
    private void collideCheck(Graphics g){
        if(bluePlane.getBullet().collideWith(enemyPlane)){
            enemyPlane.setVisible(false);
            bluePlane.getBullet().setVisible(false);
            mediator.handle(g, enemyPlane.getX(), enemyPlane.getY());
        }
        
        if(bluePlane.collideWith(enemyPlane)){
            enemyPlane.setVisible(false);
            bluePlane.setVisible(false);
            mediator.handle(g, enemyPlane.getX(), enemyPlane.getY());     
        }  
    }
    
    @Override
    public void run(){
        while(isRun){
            try{
                enemyPlane.move(0, 5);
                bluePlane.moveBullet();
                Thread.sleep(200);
                Canvas.this.repaint();                   
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }    
}
    

