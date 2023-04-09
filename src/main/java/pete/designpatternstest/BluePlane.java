/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author peter
 */

public class BluePlane extends Sprite{
    
    private CopyOnWriteArrayList<Bullet>bulletList = new CopyOnWriteArrayList<Bullet>();
    
    public BluePlane (int x, int y){
        super(x, y, ImageCache.get("bluePlaneImage"));
    }
    
    public void createBullets(){
        if(this.bulletList.size()<100){
        Bullet bullet = new RedBullet(-100, -100);
        int x = this.getX() + this.getWidth()/2 - bullet.getWidth()/2;
        int y = this.getY() - bullet.getHeight();
        bullet.setX(x);
        bullet.setY(y);
        bullet.setVisible(true);
        this.loadBullet(bullet);
        }
    }
    
    public void loadBullet(Bullet bullet){
        bulletList.add(bullet);
    }
    
    public void drawBullets(Graphics g){
        Iterator<Bullet> iter = this.bulletList.iterator();
        while(iter.hasNext()){
            Bullet bullet = iter.next();
            if (bullet.isVisible()){
                bullet.draw(g);            
            }
        }
    }
    
    public void moveBullets(int distanceX, int distanceY){
        Iterator<Bullet> iter = this.bulletList.iterator();
        while(iter.hasNext()){
            Bullet bullet = iter.next();
            if (bullet.isVisible()){
                bullet.move(distanceX, distanceY);            
            }
        }
        
        for (int i = this.bulletList.size() - 1; i>=0; i--){
            Bullet bullet = this.bulletList.get(i);
            if(bullet.getY() + bullet.getHeight() <=0){
                this.bulletList.remove(bullet);
            }
        }        
    }
    
    public List<Bullet> getBulletList(){
        return this.bulletList;
    }
    
}



