/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.image.BufferedImage;

/**
 *
 * @author peter
 */
public class Bullet extends Sprite{
    
    public Bullet(int x, int y, BufferedImage image){
        super(x, y, image);
    }
    
    public void move(int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;
        
        //bullet can be fired when it touches top of canvas
        if(this.y + this.height <=0){
            this.setVisible(false);
        }
    }
    
}
