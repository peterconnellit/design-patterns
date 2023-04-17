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
// Provides functionality to play a sound clip when an action is triggered.
public class BoomMusic implements Media{
    
    // Constant variable that holds the path to the sound file
    private static final String SOUND_FILE_PATH = "media/impactsamp.wav";
    // Clip object to hold the loaded sound clip
    private Clip clip;
    // Boolean variable to indicate if the clip is currently playing or not
    private boolean playing = false;
    
    // Constructor that loads the sound clip from the file
    public BoomMusic(){
        try {
            // Create an AudioInputStream from the file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(SOUND_FILE_PATH).getAbsoluteFile());
            // Create a Clip object from the AudioInputStream
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            // Print error message and stack trace if there was an error loading the sound clip
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
    
    // Action method from the Media interface, plays the sound clip    
    public void action(Graphics g, int x, int y){
        System.out.println("Playing sound...");
        // Check if the clip is already playing or not
        if (!playing) {
            // If not, set the playing variable to true
            playing = true;
            // Set the frame position of the clip to 0 to start playing from the beginning
            clip.setFramePosition(0);
            // Start playing the clip
            clip.start();
            // Create a thread to check if the clip has finished playing
            Thread playingChecker = new Thread(() -> {
                try {
                    // Loop while the frame position of the clip is less than the frame length
                    while (clip.getFramePosition() < clip.getFrameLength()) {
                        // Sleep for 10 milliseconds before checking again
                        Thread.sleep(10);
                    }
                    // Stop the clip and set the playing variable to false
                    clip.stop();
                    playing = false;
                } catch (InterruptedException e) {
                    // Print stack trace if there was an error while waiting
                    e.printStackTrace();
                }
            });
            // Start the playingChecker thread
            playingChecker.start();
        }
    }

}
