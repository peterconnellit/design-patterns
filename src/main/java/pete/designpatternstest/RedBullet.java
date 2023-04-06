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
public class RedBullet extends Sprite {
    
    public RedBullet(int x, int y){        
        super(x, y, ImageCache.get("redBulletImage"));
    }
    
    public void move(int distanceX, int distanceY){
        this.x = this.x + distanceX;
        this.y = this.y + distanceY;
        if(this.y + this.height <=0){
            this.setVisible(false);
        }
    }
    
}
