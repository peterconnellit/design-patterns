/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.JApplet;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


/**
 *
 * @author peter
 */
public class BoomMusic implements Media{
    
    private static final String SOUND_FILE_PATH = "media/impactsamp.wav";
    private Clip clip;
    private boolean playing = false;
    
    public BoomMusic(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(SOUND_FILE_PATH).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    
    //old function from Runnable, no longer required
    /*public void run(){
        System.out.println("Playing sound...");
        URL url = this.getClass().getResource("media/impactsamp.wav");
        AudioClip audioClip = JApplet.newAudioClip(url);
        audioClip.play();
        System.out.println("Sound played.");
    }*/
    
        public void action(Graphics g, int x, int y){
        System.out.println("Playing sound...");
        if (!playing) {
            playing = true;
            clip.setFramePosition(0);
            clip.start();
            Thread playingChecker = new Thread(() -> {
                try {
                    while (clip.getFramePosition() < clip.getFrameLength()) {
                        Thread.sleep(10);
                    }
                    clip.stop();
                    playing = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            playingChecker.start();
        }
    }

}
