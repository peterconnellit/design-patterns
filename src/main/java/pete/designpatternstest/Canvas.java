/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author peter
 */

public class Canvas extends JPanel implements Runnable{
    
    private boolean isRun = true;
    private int canvasWidth;
    private int canvasHeight;
    private EnemyPlaneChain enemyPlaneChain;
    private boolean isInit = false; 
      
    static{ 
        ImageCache.put("enemyPlane1Image", ImageUtil.loadImage("images/enemy_plane1.png"));
        ImageCache.put("enemyPlane2Image", ImageUtil.loadImage("images/enemy_plane2.png")); 
        ImageCache.put("bossImage", ImageUtil.loadImage("images/boss.png")); 
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        new Thread(this).start();
    }
    
    private void isInit(){
        enemyPlaneChain = new EnemyPlaneChain();
        enemyPlaneChain.add(new Enemy1Handler(canvasWidth));
        enemyPlaneChain.add(new Enemy2Handler(canvasWidth));
        enemyPlaneChain.add(new EnemyBossHandler(canvasWidth));        
    }  
      
    protected void paintComponent(Graphics g){
        this.canvasWidth = this.getWidth();
        this.canvasHeight = this.getHeight();
        
        if(! isInit){
            isInit();
            isInit = true;
        }     
        super.paintComponent(g);
        enemyPlaneChain.moveEnemyPlanes(g);
    }
    
    @Override
    public void run(){
        while(isRun){
            try{
                Thread.sleep(200);
                Canvas.this.repaint();                   
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }    
}
    

