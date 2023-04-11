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
public class EnemyBossHandler implements ChainHandler{
    
    private BufferedImage enemyPlaneImage;
    private int canvasWidth;
    
    public EnemyBossHandler(int canvasWidth){
        this.enemyPlaneImage = ImageCache.get("bossImage");
        this.canvasWidth = canvasWidth;
    }
    
    @Override
    public List<Sprite> create(){
        Random rn = new Random();
        List<Sprite> spriteList = new ArrayList<Sprite>();     
        int x = rn.nextInt(canvasWidth + enemyPlaneImage.getWidth());
        int y = -enemyPlaneImage.getHeight();
        Sprite enemyPlane = new EnemyPlane(x, y, enemyPlaneImage);
        spriteList.add(enemyPlane);                 
        return spriteList;
    }  
    
}
