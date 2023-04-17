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

/* Implements an image cache to store BufferedImage objects using a key-value pair system.
Designed as a singleton class, only one instance of the class can exist.
This class can be used to efficiently store and manage images in memory.*/
public class ImageCache {
    
    // A Map object used to store the cached images using a key-value pair system.
    private static Map<String,BufferedImage> cacheMap = new HashMap<String,BufferedImage>();
    
    // The constructor is private to prevent instances of the class from being created.
    private ImageCache(){}
    
    // Adds the specified BufferedImage object to the cache with the given key.
    public static void put(String key, BufferedImage image){
        cacheMap.put(key, image);
    }
    
    // Returns the BufferedImage object associated with the given key.
    public static BufferedImage get(String key){
        return cacheMap.get(key);
    }
}
