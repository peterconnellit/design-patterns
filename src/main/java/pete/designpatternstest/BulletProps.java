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
public class BulletProps extends Bullet{
    
    public BulletProps(int x, int y){
        super(x, y, ImageCache.get("blueDecoratorImage"));
    }
    
}
