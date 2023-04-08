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

public class BluePlane extends Sprite{
    
    private Bullet bullet;
    
    public BluePlane (int x, int y){
        super(x, y, ImageCache.get("bluePlaneImage"));
    }
    
    public void loadBullet(Bullet bullet){
        this.bullet = bullet;
    }
    
    public void fireBullet(){
        if(!bullet.isVisible()){
            int x = this.x + this.width/2-bullet.getWidth()/2;
            int y = this.y - bullet.getHeight();
            bullet.setX(x);
            bullet.setY(y);
            bullet.setVisible(true);
        }                
    }
    
    public Bullet getBullet(){
        return this.bullet;
    }
}

