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

// Represents an enemy plane in the game.
public class EnemyPlane extends Sprite{
    
    // Constructor with x and y coordinates
    public EnemyPlane(int x, int y){
        // Calls the constructor of the Sprite class
        super(x, y, ImageCache.get("enemyPlaneImage"));
    }
        
}
