/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author peter
 */

/* Creates a 2D array of integers representing the map tiles and initializes it with the values.
 Also sets the canvas width and height, and overrides the draw method to draw the map tiles.*/
public class MapLayer extends TiledLayer{
    
    // The width of the canvas.
    private int canvasWidth;
    // The height of the canvas.
    private int canvasHeight;
    
    // The 2D array of integers representing the map tiles.
    private static int[][] maps = {
        {1,1,1,1,1,1,1,1,1,1},
        {1,5,1,1,5,1,1,1,5,5},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,4,1,1},
        {1,4,1,1,1,4,1,1,1,1},
        {1,1,1,5,1,1,1,4,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,4,4,1,1,1},
        {1,1,3,1,1,1,1,1,1,3},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,3,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,2,1,1,1,2,1,1,1},
        {1,1,1,2,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,2,1,1,1,1,2},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,2,1,1,1,1,2,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,3,1,1,3,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,3,1,1,1,3,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1}
    };
    
    public MapLayer(int canvasWidth, int canvasHeight){
        // Call the constructor of the TiledLayer superclass with the appropriate arguments
        super(ImageCache.get("mapImage"), maps,
             32, 32, 10, 30);
        // Store the canvas width and height as instance variables
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }
    
    @Override
    public void draw(Graphics g){
        // Translate the graphics context to the current view position
        g.translate(viewX, viewY);
        // Iterate through the map array and draw each tile
        for(int i=0; i<maps.length; i++)
        {
            for(int j=0; j<maps[i].length; j++)
            {
                int x=j*tiledWidth;
                int y=i*tiledHeight;
                
                // Set the clip region to the bounds of the current tile
                g.setClip(x, y, tiledWidth, tiledHeight);
                // Draw the tile image with an offset based on its value in the map array
                g.drawImage(image, x-(maps[i][j]-1)*tiledWidth, y, null);
            }
        }
        // Reset the clip region to the entire canvas except for the bottom row of tiles
        g.setClip(0, 0, this.canvasWidth, this.canvasHeight - viewY);
        // Translate the graphics context back to its original position
        g.translate(-viewX, -viewY);
    }
    
}
