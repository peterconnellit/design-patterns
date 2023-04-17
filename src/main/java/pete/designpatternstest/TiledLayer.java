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

// Abstract class for creating and managing tiled layers for background
public abstract class TiledLayer {
    
    // The image used for the tiled layer.
    protected BufferedImage image;
    // A two-dimensional array of integers representing the tile maps for the layer.
    protected int[][]maps;
    // The width of each tile.
    protected int tiledWidth;
    // The height of each tile.
    protected int tiledHeight;
    // Number of columns and rows in the tile map.
    protected int col, row;
    // Coordinates.
    protected int viewX, viewY;
    
    /// Constructor.
    public TiledLayer(BufferedImage image, int[][]maps, int tiledWidth,
        int tiledHeight, int col, int row){
        this.image = image;
        this.maps = maps;
        this.tiledWidth = tiledWidth;
        this.tiledHeight = tiledHeight;
        this.col = col;
        this.row = row;
    }
    
    // Sets the view port for the tiled layer.
    public void setViewPort(int viewX, int viewY){
        this.viewX = viewX;
        this.viewY = viewY;
    }
    
    // Abstract method for drawing the tiled layer.
    public abstract void draw(Graphics g);
    
    // Gets the tile maps for the tiled layer.
    public int[][] getMaps(){
        return maps;
    }
    
    // Sets the tile maps for the tiled layer.
    public void setMaps(int[][] maps){
        this.maps = maps;
    }
    
    // Gets the width of each tile.
    public int getTiledWidth(){
        return tiledWidth;
    }
    
    // Sets the width of each tile.
    public void setTiledWidth(int tiledWidth){
        this.tiledWidth = tiledWidth;
    }
    
    // Gets the height of each tile.
    public int getTiledHeight(){
        return tiledHeight;
    }
    
    // Sets the tiled height 
    public void setTiledHeight(int tiledHeight){
        this.tiledHeight = tiledHeight;
    }
    
    // Returns the column value of the TiledLayer object.
    public int getCol(){
        return col;
    }
    
    // Sets the column value of the TiledLayer object to the provided value.
    public void setCol(int col){
        this.col = col;
    }
    
    // Returns the row value of the TiledLayer object.
    public int getRow(){
        return row;
    }
    
    // Sets the row value of the TiledLayer object to the provided value.
    public void setRow(int row){
        this.row = row;
    }
    
}
