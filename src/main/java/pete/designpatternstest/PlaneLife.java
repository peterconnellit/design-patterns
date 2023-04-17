/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;

/**
 *
 * @author peter
 */

//Represents the sprite that displays the remaining lives of the player's plane in the game.
public class PlaneLife extends Sprite implements Observer{
    
    // stores the number of remaining
    protected int lifeCount = 3;
    // stores the width of the canvas
    private int canvasWidth;
    // stores the height of the canvas
    private int canvasHeight;
    
    // Constructor
    public PlaneLife(int x, int y, int canvasWidth, int canvasHeight){
        super (x, y, ImageCache.get("bluePlaneLifeImage"));
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }
    
    /* This method draws the sprite on the canvas.
    It uses a loop to draw the remaining lives on the bottom of the canvas.
    @param g the Graphics object used for drawing. */
    public void draw(Graphics g){
        for(int i=0; i<lifeCount; i++){
        g.drawImage(this.image, i*(this.width+2), this.canvasHeight-20,null);
        }
    }
    
    /* This method is called by the subject when its state changes.
    It updates the remaining life count if the notification type is PLANE_DESTROY.
    @param data the ObserverData object containing the new state of the observed object.*/
    @Override
    public void update(ObserverData data){
        if(data.getNotifyType() == NotifyType.PLANE_DESTROY){
            this.lifeCount --;
        }
    }
    
}
