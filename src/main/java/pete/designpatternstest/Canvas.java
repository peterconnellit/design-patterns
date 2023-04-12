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
    private PlaneLife planeLife;
    private PlaneScore planeScore;
    private int canvasWidth;
    private int canvasHeight;
    private boolean isInit = false; 
      
    static{ 
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("enemyPlaneImage", ImageUtil.loadImage("images/enemy_plane.png")); 
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane1.png")); 
        ImageCache.put("bluePlaneLifeImage", ImageUtil.loadImage("images/blue_plane_small.png")); 
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
        
        planeLife = new PlaneLife(0, 0, canvasWidth, canvasHeight);
        bluePlane.registerObserver(planeLife);
        
        planeScore = new PlaneScore(0, 0, canvasWidth, canvasHeight);
        bluePlane.registerObserver(planeScore);
        
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
                Canvas.this.repaint();
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
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);
        enemyPlane.draw(g);
        planeLife.draw(g);
        planeScore.draw(g);
    }
    
    private void collideCheck(){
        if(bluePlane.getBullet().collideWith(enemyPlane)){
            enemyPlane.setVisible(false);
            bluePlane.getBullet().setVisible(false);
            
            ObserverData data = new ObserverData();
            data.setNotifyType(NotifyType.INCREMENT_SCORE);
            data.setScore(100);
            bluePlane.notifyAll(data);
        }
        
        if(bluePlane.collideWith(enemyPlane)){
            enemyPlane.setVisible(false);
            bluePlane.setVisible(false);
            
        ObserverData data = new ObserverData();
        data.setNotifyType(NotifyType.PLANE_DESTROY);
        bluePlane.notifyAll(data);
        
        bluePlane.setX(this.canvasWidth/2 - bluePlane.getWidth()/2);
        bluePlane.setY(this.canvasHeight - bluePlane.getHeight() - 30);       
        }  
    }
    
    public void run(){
        while(isRun){
            try{
                enemyPlane.move(0, 5);
                collideCheck();
                bluePlane.moveBullet();
                Thread.sleep(200);
                Canvas.this.repaint();                   
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }    
}
    

