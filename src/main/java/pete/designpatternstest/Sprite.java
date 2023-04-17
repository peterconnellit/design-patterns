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

/* Abstract class that represents a sprite in a game.
Also defines methods for drawing, moving, and checking for collisions with other sprites.*/
abstract class Sprite {
    // Fields to store the position, dimensions, image, and visibility of the sprite
    protected int x;
    protected int y;
    protected int width;
    protected int height;    
    protected BufferedImage image;
    protected boolean visible;

    // Constructor that initialises the position, image, and dimensions of the sprite.
    public Sprite (int x, int y, BufferedImage image){
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }
    
    // Draws the sprite, if it is visible.
    public void draw(Graphics g){
        if(this.isVisible()){
        g.drawImage(image, this.x, this.y, null);
        }        
    }
    
    // Moves the sprite by the specified distance in the x and y directions.
    public void move(int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;        
    }
    
    // Checks whether this sprite collides with the specified sprite.
    public boolean collideWith(Sprite sprite){
        if(this.isVisible() && sprite.isVisible()){
            int centerX = this.x + this.getWidth()/2;
            int centerY = this.y + this.getHeight()/2;
            int spriteCenterX = sprite.getX() + sprite.getWidth()/2;
            int spriteCenterY = sprite.getY() + sprite.getHeight()/2;
            
                 // Checks the distance between the centers of the sprites
            if(Math.abs(centerX - spriteCenterX) < (this.width/2 + sprite.getWidth()/2)
               &&
              Math.abs(centerY - spriteCenterY) < (this.height/2 + sprite.getHeight()/2))
              return true;
            else
              return false;            
            }
        return false;
    }
      
    /* Getter and setter methods for the width, height, x-coordinate, and y-coordinate of the sprite.
    These methods are used to manipulate the appearance and visibility of the sprite.*/
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
    
    /* Returns the current visibility status of the sprite.     
    These methods are used to manipulate the appearance and visibility of the sprite.*/
    public boolean isVisible(){
        return visible;
    }
    
    // Sets the visibility status of the sprite to the given value.
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    // Returns the image associated with the sprite.
    public BufferedImage getImage(){
        return image;
    }
    
}