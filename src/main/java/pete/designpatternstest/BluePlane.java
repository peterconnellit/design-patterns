/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 *
 * @author peter
 */

public class BluePlane extends Sprite{
    
    protected RedBullet bullet;
    protected List<Observer> observerList = new ArrayList<Observer>();
    private int canvasWidth;
    private int canvasHeight;
    
    
    public BluePlane (int x, int y){
        super(x, y, ImageCache.get("bluePlaneImage"));
    }
    
    public void loadBullet(RedBullet bullet){
        this.bullet = bullet;
    }
    
    public void fireBullet(){
        if(!bullet.isVisible()){
            int x = this.x + this.width/2-bullet.getWidth()/2;
            int y = this.y-bullet.getHeight();
            bullet.setX(x);
            bullet.setY(y);
            bullet.setVisible(true);
        }
    }
    
    public void moveBullet(){
        if(this.bullet.isVisible()){
            this.bullet.move(0, -5);
        }
    }
    
    public void registerObserver(Observer observer){
        observerList.add(observer);
    }
    
    public void notifyAll(ObserverData data){
        for(int i=0; i<observerList.size(); i++){
            Observer observer = observerList.get(i);
            observer.update(data);
        }
    }
    
    public RedBullet getBullet(){
        return this.bullet;
    }
    
}



