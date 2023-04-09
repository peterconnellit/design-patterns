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
public class PlaneDecorator extends Plane{
    
    private CopyOnWriteArrayList<Bullet>bulletList = new CopyOnWriteArrayList<Bullet>();
    private BufferedImage bulletImage;
    private Plane plane;
    private int canvasHeight;
    
    public PlaneDecorator(Plane plane, int canvasHeight){
        super(plane.getX(), plane.getY(), plane.getImage());
        this.plane = plane;
        this.canvasHeight = canvasHeight;
    }
    
    public void loadBulletImage(BufferedImage bulletImage){
        super.loadBulletImage(bulletImage);
        this.bulletImage = bulletImage;
    }
    
    public void move(int distanceX, int distanceY){
        plane.move(distanceX, distanceY);
        super.move(distanceX, distanceY);
    }  
    
    public void createBullets(){
        plane.createBullets();
        if(this.bulletList.size()<100){
        Bullet bullet = new RedBullet(-100, -100);
        int x = this.getX() + this.getWidth()/2 - bullet.getWidth()/2;
        int y = this.getY() - this.getHeight();
        bullet.setX(x);
        bullet.setY(y);
        bullet.setVisible(true);
        bulletList.add(bullet);
        }
    }
    
    public void drawBullets(Graphics g){
        plane.drawBullets(g);
        Iterator<Bullet> iter = this.bulletList.iterator();
        while(iter.hasNext()){
            Bullet bullet = iter.next();
            if (bullet.isVisible()){
                bullet.draw(g);            
            }
        }
    }
    
    public void moveBullets(int distanceX, int distanceY){
        plane.moveBullet(distanceX, distanceY);
        Iterator<Bullet> iter = this.bulletList.iterator();
        while(iter.hasNext()){
            Bullet bullet = iter.next();
            if (bullet.isVisible()){
                bullet.move(distanceX, distanceY);            
            }
        }
        
        for (int i = this.bulletList.size() - 1; i>=0; i--){
            Bullet bullet = this.bulletList.get(i);
            if(bullet.getY() > canvasHeight){
                this.bulletList.remove(bullet);
            }
        }        
    }    
}
