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

class Sprite {
    protected int x;
    protected int y;
    protected BufferedImage image;

    public Sprite (int x, int y, BufferedImage image){
        this.x = x;
        this.y = y;
        this.image = image;               
    }
    
    public void draw(Graphics g){        
        g.drawImage(image, this.x, this.y, null);        
    }
    

}