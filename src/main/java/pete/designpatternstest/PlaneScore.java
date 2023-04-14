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
public class PlaneScore implements Observer{
    
    protected int x;
    protected int y;
    protected int score;
    private int canvasWidth;
    private int canvasHeight;
    
    public PlaneScore(int x, int y, int canvasWidth, int canvasHeight){
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.x = canvasWidth - 30;
        this.y = canvasHeight - 10;
    }
    
    public void draw(Graphics g){
        Font font = new Font("Arial", Font.BOLD, 15); // set font size to 24
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(score), x, y);
    }
    
    @Override
    public void update(ObserverData data){
        if(data.getNotifyType() == NotifyType.INCREMENT_SCORE){
            this.score += data.getScore();
        }
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
}
