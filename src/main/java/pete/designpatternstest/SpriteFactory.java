/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


/**
 *
 * @author peter
 */
public class SpriteFactory {
    
    public static Sprite create (String type, int x, int y){
        if("1".equals(type)){
            BufferedImage image = ImageUtil.loadImage("images/blue_plane.png");
            return new BluePlane(x, y, image);
        }else if("2".equals(type)){
            BufferedImage image = ImageUtil.loadImage("images/red_plane.png");
            return new RedPlane(x, y, image);
        }
        return null;
    }
    
}
