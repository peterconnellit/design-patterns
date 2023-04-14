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
public class Boom extends Sprite implements Media{
    
    public Boom(){
        super(0, 0, ImageCache.get("explosionImage"));
    }
    
    
    @Override
    public void action(Graphics g, int x, int y){
        this.setVisible(true);
        this.x = x;
        this.y = y;
        super.draw(g);
        this.setVisible(false);
        System.out.println("Adios ya bad egg...");
    }
    
}
