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

/* This class provides utility methods for working with images.
The class is designed as a singleton*/
public class ImageUtil {
    
    // The constructor is private to prevent instances of the class from being created
    private ImageUtil(){      
    }
    
    // Loads a BufferedImage from the specified file path.
    public static BufferedImage loadImage(String imagePath){
        File file = new File(imagePath);
        BufferedImage bufferedImage = null;
        try{
            bufferedImage = ImageIO.read(file);
        }catch(IOException e){
            e.printStackTrace();
        }
        return bufferedImage;
    }
    
}
