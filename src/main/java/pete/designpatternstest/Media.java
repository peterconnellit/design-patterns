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
// Defines the action method for explosion
public interface Media {
    
    // Action method that takes in a Graphics object and two integer parameters
    public void action (Graphics g, int x, int y);
    
}
