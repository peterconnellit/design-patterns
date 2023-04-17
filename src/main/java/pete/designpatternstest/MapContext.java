/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.util.*;

/**
 *
 * @author peter
 */

/* The MapContext class is responsible for managing the TiledLayer objects 
and providing access to them in a sequential manner.
The class contains a LinkedList of TiledLayer objects, which can be added to 
using the addMap() method. The next() method returns the next TiledLayer in 
the list each time it is called, cycling back to the beginning of the list 
if the end is reached.*/
public class MapContext {
    
    // LinkedList of TiledLayer objects
    private LinkedList<TiledLayer> tiledLayerList = new LinkedList<TiledLayer>();
    // Index of the next TiledLayer to be returned by next()
    private int index;
    
    // Constructor
    public MapContext(){        
    }
    
    // Adds a TiledLayer to the list of TiledLayers.
    public void addMap(TiledLayer tiledLayer){
        tiledLayerList.add(tiledLayer);
    }
    
    /* Returns the next TiledLayer in the list.
    If the end of the list is reached, the index is reset to 0.*/
    public TiledLayer next(){
        if(index >= tiledLayerList.size())
        {
            index = 0;
        }
        TiledLayer tiledLayer = tiledLayerList.get(index);
        index++;
        return tiledLayer;
    }
    
}
