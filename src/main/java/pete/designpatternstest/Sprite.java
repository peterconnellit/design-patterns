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
    
    public void move(int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;        
    }
    
    public boolean collideWith(Sprite sprite){
        if(this.isVisible() && sprite.isVisible()){
            int centerX = this.x + this.getWidth()/2;
            int centerY = this.y + this.getHeight()/2;
            int spriteCenterX = sprite.getX() + sprite.getWidth()/2;
            int spriteCenterY = sprite.getY() + sprite.getHeight()/2;
            
            if(Math.abs(centerX - spriteCenterX) < (this.width/2 + sprite.getWidth()/2)
               &&
              Math.abs(centerY - spriteCenterY) < (this.height/2 + sprite.getHeight()/2))
              return true;
            else
              return false;            
            }
        return false;
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