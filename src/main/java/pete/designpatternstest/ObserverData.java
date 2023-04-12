/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

/**
 *
 * @author peter
 */
public class ObserverData {
    
    private int score;
    private NotifyType notifyType;
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
    public NotifyType getNotifyType(){
        return notifyType;
    }
    
    public void setNotifyType(NotifyType notifyType){
        this.notifyType = notifyType;
    }
    
}
