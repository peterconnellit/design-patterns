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

// Represents a red bullet in the game.
public class RedBullet extends Sprite{
    
    // Constructor
    public RedBullet(int x, int y){
        // calls the constructor of the Sprite class        
        super(x, y, ImageCache.get("redBulletImage"));
    }
    
    /* Draws the bullet on the screen if it is visible.
       Overrides the draw method in the Sprite class.
       @param g The graphics object used to draw the bullet.*/
    public void draw(Graphics g){
        if(this.isVisible()){
            // Calls the draw method of the Sprite class
            super.draw(g);
        }
    }
    
    /* Moves the bullet by the specified distance.
    If the bullet goes out of the screen, it becomes invisible.*/
    public void move(int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;
        if(this.y + this.height <=0){
            this.setVisible(false);
        }
    }
        
}
