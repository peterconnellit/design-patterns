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

// Similar implimentation to MapLayer class. This sets space background.
public class Map2Layer extends TiledLayer{
    
    private int canvasWidth;
    private int canvasHeight;
    
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
    
    public Map2Layer(int canvasWidth, int canvasHeight){
        super(ImageCache.get("map2Image"), maps,
             32, 32, 10, 30);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }
    
    @Override
    public void draw(Graphics g){
        g.translate(viewX, viewY);
        for(int i=0; i<maps.length; i++)
        {
            for(int j=0; j<maps[i].length; j++)
            {
                int x=j*tiledWidth;
                int y=i*tiledHeight;
                g.setClip(x, y, tiledWidth, tiledHeight);
                g.drawImage(image, x-(maps[i][j]-1)*tiledWidth, y, null);
            }
        }
        g.setClip(0, 0, this.canvasWidth, this.canvasHeight - viewY);
        g.translate(-viewX, -viewY);
    }
    
}
