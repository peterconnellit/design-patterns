/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pete.designpatternstest;

import java.io.*;

public class TestAudioFile {
    public static void main(String[] args) {
        File audioFile = new File("media/impactsamp.wav");
        try {
            FileInputStream fis = new FileInputStream(audioFile);
            System.out.println("Audio file path is correct!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: audio file not found at path " + audioFile.getAbsolutePath());
        }
    }
}