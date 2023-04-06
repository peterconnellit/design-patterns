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
public class ImageUtil {
    
    private ImageUtil(){
        
    }
    
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
