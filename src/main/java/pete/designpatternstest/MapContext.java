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
public class MapContext {
    
    private LinkedList<TiledLayer> tiledLayerList = new LinkedList<TiledLayer>();
    private int index;
    
    public MapContext(){        
    }
    
    public void addMap(TiledLayer tiledLayer){
        tiledLayerList.add(tiledLayer);
    }
    
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
