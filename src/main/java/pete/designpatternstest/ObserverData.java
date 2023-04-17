/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

/**
 *
 * @author peter
 */

/*The ObserverData class represents the data that is sent to observers
when the state of the observed object changes.*/
public class ObserverData {
    
    // stores the score value
    private int score;
    // stores the type of notification to be sent
    private NotifyType notifyType;
    
    public int getScore(){
        return score;
    }
    
    // Sets the score value.
    public void setScore(int score){
        this.score = score;
    }
    
    // Returns the type of notification to be sent.
    public NotifyType getNotifyType(){
        return notifyType;
    }
    
    // Sets the type of notification to be sent.
    public void setNotifyType(NotifyType notifyType){
        this.notifyType = notifyType;
    }
    
}
