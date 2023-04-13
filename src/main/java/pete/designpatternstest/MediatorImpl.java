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
public class MediatorImpl implements Mediator{
    
    private Boom boom;
    private BoomMusic boomMusic;
    
    public MediatorImpl(){
        boom = new Boom();
        boomMusic = new BoomMusic();
    }
    
    @Override
    public void handle(Graphics g, int x, int y){
        System.out.println("Mediator handling collision...");
        boom.action(g, x, y);
        boomMusic.action(g, x, y);
    }    
}
