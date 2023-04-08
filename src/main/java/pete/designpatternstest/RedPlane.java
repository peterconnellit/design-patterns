/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.image.BufferedImage;

/**
 *
 * @author peter
 */

public class RedPlane extends Plane{
    
    public RedPlane (int x, int y){
        super(x, y, ImageCache.get("redPlaneImage"));
    }
    
}
