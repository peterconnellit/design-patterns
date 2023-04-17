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

// Subclass of the Sprite class.
public class BluePlane extends Sprite{
    
    // Red bullet instance to be fired by the blue plane
    protected RedBullet bullet;
    // List of observers to be notified when a change happens to the blue plane
    protected List<Observer> observerList = new ArrayList<Observer>();
    // Width and height of the game canvas
    private int canvasWidth;
    private int canvasHeight;
    
    // Constructor
    public BluePlane (int x, int y){
        //Calling the constructor of the superclass
        super(x, y, ImageCache.get("bluePlaneImage"));
    }
    
    //Loads the red bullet instance to be fired by the blue plane
    public void loadBullet(RedBullet bullet){
        this.bullet = bullet;
    }
    
    //Fires the red bullet instance if it is not already visible on the game canvas
    public void fireBullet(){
        if(!bullet.isVisible()){
            int x = this.x + this.width/2-bullet.getWidth()/2;
            int y = this.y-bullet.getHeight();
            bullet.setX(x);
            bullet.setY(y);
            bullet.setVisible(true);
        }
    }
    
    // Moves the red bullet instance upwards on the game canvas
    public void moveBullet(){
        if(this.bullet.isVisible()){
            this.bullet.move(0, -5);
        }
    }
    
    // Returns the red bullet instance
    public RedBullet getBullet(){
        return this.bullet;
    }
    
    // Registers an observer to the observer list
    public void registerObserver(Observer observer){
        observerList.add(observer);
    }

    // Notifies all the registered observers with the given ObserverData
    public void notifyAll(ObserverData data){
        for(int i=0; i<observerList.size(); i++){
            Observer observer = observerList.get(i);
            observer.update(data);
        }
    }
}



