/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.io.*;
import javax.sound.sampled.*;

/**
 *
 * @author peter
 */
// Provides a method to play a given audio file.
public class PlayAudio {
    
    // File path of the audio file
    private String filename;
    
    // Constructor to set the filename.
    public PlayAudio(String wavfile){
        // File path of the WAV file to play
        filename = wavfile;
    }
    
     /* Method to play the audio file.
     Uses AudioSystem and SourceDataLine from javax.sound.sampled library.*/
    public void run(){
        File soundFile = new File(filename);
        AudioInputStream audioInputStream = null;
        SourceDataLine auline = null;
        try{
            //Create an AudioInputStream from the file
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();
            //Create a DataLine.Info object that describes the desired line
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            
            //Obtain a SourceDataLine that can be used to play back the audio
            auline = (SourceDataLine) AudioSystem.getLine(info);
            //Open the line with the specified format
            auline.open(format);
            
            //Start playing the audio
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[1024];
            //Loop to read from the AudioInputStream and write to the SourceDataLine
            while(nBytesRead !=-1){
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (Exception e){
            e.printStackTrace();
            return;
        } finally {
            //Drain the line and close it
            auline.drain();
            auline.close();
        }      
    }
}
