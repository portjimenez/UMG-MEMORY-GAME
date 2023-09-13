package Tarea5;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    public class Sonido extends Thread {
    private Clip clip;
    private final String Sonidofolder = "./src/Sonido/";
    private final String[] SonidoList = {"Mr. Robot.wav"};
    private int SonidoType;
    
    public enum SonidoType {Cargando,Empezar};
    private int SonidoSelected;
    void HiloSonido(){
}
    void SonidoType(int SonidoSelected)
    {
        this.SonidoType = SonidoSelected;
    }
    public void run(){
        
        File file = new File("");
        switch(this.SonidoSelected){
            case 0:
                file = new File(this.Sonidofolder + this.SonidoList[0]);
                break;
           
        
        }
         try 
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HiloSonido.Run(). " + e + ". Ruta: " + file.getParent());
        }
    }
    
    
}

