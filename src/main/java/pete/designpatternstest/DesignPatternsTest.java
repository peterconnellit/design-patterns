/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pete.designpatternstest;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author peter
 */

/* Contains the main method for running the program.
Creates a new JFrame, adds a Canvas to it, sets the size,
and makes the frame visible.*/
public class DesignPatternsTest {

    public static void main(String[] args) {
        
        // Create a new JFrame with a title
        JFrame frame = new JFrame("Airborne Absurdity");
        // Create a new Canvas
        Canvas canvas = new Canvas();
        // Add the Canvas to the center of the JFrame
        frame.add(canvas, BorderLayout.CENTER);
        // Set the size of the JFrame
        frame.setSize(300,500);
        // Make the Canvas focusable, visible and request focus
        canvas.setFocusable(true);
        frame.setVisible(true);
        canvas.requestFocus();
    }
}
