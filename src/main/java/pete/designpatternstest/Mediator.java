/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pete.designpatternstest;


import java.awt.Graphics;

/**
 *
 * @author peter
 */
/* Defines a method that can be used to handle events,
without specifying the actual implementation of the event handler.*/
public interface Mediator {
    
    // Parameters set object used to draw on screen and coordinated where event was triggered
    public void handle(Graphics g, int x, int y);
    
}
