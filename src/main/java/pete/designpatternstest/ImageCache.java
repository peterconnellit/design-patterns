/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 *
 * @author peter
 */
public class ImageCache {
    
    private static Map<String,BufferedImage> cacheMap = new HashMap<String,BufferedImage>();
    
    private ImageCache(){}
    
    public static void put(String key, BufferedImage image){
        cacheMap.put(key, image);
    }
    
    public static BufferedImage get(String key){
        return cacheMap.get(key);
    }
}
