/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pete.designpatternstest;

/**
 *
 * @author peter
 */

// Observer interface
public interface Observer {
    
    /* This method is called by the subject when its state changes.
    The observer can use the ObserverData object passed as a parameter to update its state accordingly.
    @param data the ObserverData object containing the new state of the observed object*/   
    public void update(ObserverData data);
    
}
