/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author peter
 */

abstract class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;
    protected boolean visible;
    
    public Sprite (int x, int y, BufferedImage image){
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();                
    }
    
    public void draw(Graphics g){
        if(this.isVisible()){
        g.drawImage(image, this.x, this.y, null);
        }
    }
    
    public void move (int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;        
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public boolean isVisible(){
        return visible;
    }
    
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    public BufferedImage getImage(){
        return image;
    }
}