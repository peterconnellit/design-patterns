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
public class PlayAudio {
    
    private String filename;
    
    public PlayAudio(String wavfile){
        filename = wavfile;
    }
    
    public void run(){
        File soundFile = new File(filename);
        AudioInputStream audioInputStream = null;
        SourceDataLine auline = null;
        try{
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
            
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[1024];
            while(nBytesRead !=-1){
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (Exception e){
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }      
    }
}
