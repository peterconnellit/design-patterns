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
public class Enemy1Handler implements ChainHandler{
    
    private BufferedImage enemyPlaneImage;
    private int canvasWidth;
    
    public Enemy1Handler(int canvasWidth){
        this.enemyPlaneImage = ImageCache.get("enemyPlane1Image");
        this.canvasWidth = canvasWidth;
    }
    
    @Override
    public List<Sprite> create(){
        Random rn = new Random();
        List<Sprite> spriteList = new ArrayList<Sprite>();
        for(int i=0; i<2 ;i++){
            int x = rn.nextInt(canvasWidth + enemyPlaneImage.getWidth());
            int y = -enemyPlaneImage.getHeight();
            Sprite enemyPlane = new EnemyPlane(x, y, enemyPlaneImage);
            spriteList.add(enemyPlane);          
        }
        return spriteList;
    }    
}
