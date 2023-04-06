/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author peter
 */

public class Canvas extends JPanel implements Runnable{
    
    private boolean isRun = true;
    private BluePlane bluePlane;
    private int canvasWidth;
    private int canvasHeight;
    
    static{
        ImageCache.put("redBulletImage", ImageUtil.loadImage("images/red_bullet.png"));
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
    }
    
    public Canvas(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        
        bluePlane = new BluePlane(120,250);
        bluePlane.loadBullet(new RedBullet(-100, -100));
        bluePlane.setVisible(true);
        
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
        super.paintComponent(g);
        bluePlane.draw(g);
        bluePlane.getBullet().draw(g);        
    }
    
    @Override
    public void run(){
        while(isRun){
            try{
                bluePlane.moveBullet();
                Thread.sleep(50);
                Canvas.this.repaint();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    
}
