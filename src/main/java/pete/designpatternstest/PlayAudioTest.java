/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

/**
 *
 * @author peter
 */
public class PlayAudioTest {
    
    public static void main(String[] args) {
        String filename = "media/impactsamp.wav";
        PlayAudio player = new PlayAudio(filename);
        player.run();
    }

    
}
