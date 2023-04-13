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
    private boolean isInit = false;
    private int canvasWidth;
    private int canvasHeight;
    private TiledLayer mapLayer;
    private MapContext mapContext;
    private int screenY;
      
    static{
        BufferedImage mapImage=ImageUtil.loadImage("images/grass.png");       
        ImageCache.put("mapImage", mapImage);
        BufferedImage map2Image=ImageUtil.loadImage("images/space.png");        
        ImageCache.put("map2Image", map2Image);
    }
    
    public Canvas(){    
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }
    
    private void init(){
        mapContext = new MapContext();
        mapContext.addMap(new MapLayer(this.canvasWidth, this.canvasHeight));
        mapContext.addMap(new Map2Layer(this.canvasWidth, this.canvasHeight));
        mapLayer = mapContext.next();
        screenY = -this.canvasHeight;     
        new Thread(this).start();              
    }  
      
    protected void paintComponent(Graphics g){
        this.canvasWidth = this.getWidth();
        this.canvasHeight = this.getHeight();        
        if(!isInit){
            init();
            isInit = true;
        }     
        super.paintComponent(g);       
        drawMap(g);
    }
    
    public void drawMap(Graphics g){
        mapLayer.setViewPort(0, screenY);
        mapLayer.draw(g);
        if(screenY<=0){
            screenY++;
        }
        if(screenY>=0){
            screenY = -this.canvasHeight;
            mapLayer = mapContext.next();
        }
    }
    
    @Override
    public void run(){
        while(isRun){
            try{
                Thread.sleep(100);
                Canvas.this.repaint();                   
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }    
}
    

