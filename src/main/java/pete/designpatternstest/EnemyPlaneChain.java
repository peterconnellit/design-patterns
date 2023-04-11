/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author peter
 */
public class EnemyPlaneChain {
    
    private LinkedList<ChainHandler> chainList = new LinkedList<ChainHandler>();
    private int timeline = 45;
    private List<Sprite> enemyPlaneList = new ArrayList<Sprite>();
    
    public void add(ChainHandler chainHandler){
        chainList.add(chainHandler);
    }
    
    public void moveEnemyPlanes(Graphics g){
        if (enemyPlaneList ==null){
            return;
        }
        
        if(timeline >0 && timeline %15 ==0 && chainList.size() >0){
            ChainHandler currentChainHandler = chainList.poll();
            List<Sprite>spriteList = currentChainHandler.create();
            enemyPlaneList.addAll(spriteList);
        }
        
        for(int i=0; i<enemyPlaneList.size(); i++){
            Sprite enemyPlane = enemyPlaneList.get(i);
            enemyPlane.draw(g);
            enemyPlane.move(0, 5);
        }
        
        timeline --;        
    }   
}
