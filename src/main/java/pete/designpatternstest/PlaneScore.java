/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Color;


/**
 *
 * @author peter
 */

// Represents the score of the player's plane in the game.
public class PlaneScore implements Observer{
    
    // x and y coordinates of the score display.
    protected int x;
    protected int y;
    // stores the current score
    protected int score;
    // stores the width of the canvas
    private int canvasWidth;
    // stores the height of the canvas
    private int canvasHeight;
    
    // Constructor
    public PlaneScore(int x, int y, int canvasWidth, int canvasHeight){
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.x = canvasWidth - 30;
        this.y = canvasHeight - 10;
    }
    
    /* This method draws the score on the canvas.
    It sets the font and colour, and then draws the score using the Graphics object.
    @param g the Graphics object used for drawing.*/
    public void draw(Graphics g){
        Font font = new Font("Arial", Font.BOLD, 15); // set font size to 24
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(score), x, y);
    }
    
    /* This method is called by the subject when its state changes.
    It updates the score if the notification type is INCREMENT_SCORE.
    @param data the ObserverData object containing the new state of the observed object. */
    @Override
    public void update(ObserverData data){
        if(data.getNotifyType() == NotifyType.INCREMENT_SCORE){
            this.score += data.getScore();
        }
    }
    
    // Sets the x and y coordinate of the score display.
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
}
