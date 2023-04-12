/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.Graphics;

/**
 *
 * @author peter
 */
public class PlaneLife extends Sprite implements Observer{
    
    protected int lifeCount = 3;
    private int canvasWidth;
    private int canvasHeight;
    
    public PlaneLife(int x, int y, int canvasWidth, int canvasHeight){
        super (x, y, ImageCache.get("bluePlaneLifeImage"));
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }
    
    public void draw(Graphics g){
        for(int i=0; i<lifeCount; i++){
        g.drawImage(this.image, i*(this.width+2), this.canvasHeight-20,null);
        }
    }
    
    @Override
    public void update(ObserverData data){
        if(data.getNotifyType() == NotifyType.PLANE_DESTROY){
            this.lifeCount --;
        }
    }
    
}
