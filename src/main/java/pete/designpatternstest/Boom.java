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
// Represents an explosion sprite that can be displayed on the screen
public class Boom extends Sprite implements Media{
    
    public Boom(){
        // Call the superclass constructor to set the initial position and image.
        super(0, 0, ImageCache.get("explosionImage"));
    }
    
    // Displays the explosion sprite on the screen at the specified coordinates.
    @Override
    public void action(Graphics g, int x, int y){
        // Make the sprite visible.
        this.setVisible(true);
        // Set the sprite's location.
        this.x = x;
        this.y = y;
        // Draw the sprite on the screen.
        super.draw(g);
        // Hide the sprite.
        this.setVisible(false);
        // Print a message to the console.
        System.out.println("Adios ya bad egg...");
    }
    
}
