/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author peter
 */

public class Canvas extends JPanel {
    
    private Sprite plane;
    private String type;
    
    static{
        ImageCache.put("redPlaneImage", ImageUtil.loadImage("images/red_plane.png"));
        ImageCache.put("bluePlaneImage", ImageUtil.loadImage("images/blue_plane.png"));
    }
    
    public Canvas(String type){
        this.type = type;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        plane = SpriteFactory.create(type, 120, 250);
    }
    
    protected void paintComponent(Graphics g){ 
        super.paintComponent(g);
        plane.draw(g);           
    }
       
}
