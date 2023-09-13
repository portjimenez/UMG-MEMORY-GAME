package Tarea5;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author Jorge
 */
public class funcioness {
    
     public static void nombreU(JLabel u){
    new Thread(){
     
        public void run(){
            try{
                String[] texto = {"Universidad", "Mariano", "Galvez","Belen"};
                for(int i=0; i<4; i++){
                    u.setText(texto[i]);
                    u.setAlignmentY(SwingConstants.CENTER);
                    Thread.sleep(1000);
                    if(i==3){
                        i=-1;
                    }
                }
            }catch(Exception e){

            }
        }
        }.start();
}
    
    public static void Regima(JLabel jLabel, String pad)
    {
        //EJEMPLO DE UN PATH RELATIVO
    
       Path pathRelativo = Paths.get("./src/img/logo.png");
             Path pathRelativo2 = Paths.get("./src/img/"+".png");
        //("./src/img/logo.png")

        //GENERA UNA IMAGEN UTILIZANDO UNA RUTA A UNA ARCHIVO
        ImageIcon logoOriginal = new ImageIcon(pad);
    
        ImageIcon logoRedimensionado = new ImageIcon(logoOriginal.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH));
        //imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH)
        jLabel.setIcon(logoRedimensionado); 
    //

    }
    public static void CargarLogo(JLabel jLabel)
    {
        //EJEMPLO DE UN PATH RELATIVO
         ImageIcon logoOriginal2 = new ImageIcon("./src/img/logo.png");
        //GENERA UNA IMAGEN UTILIZANDO UNA RUTA A UNA ARCHIVO
    
        ImageIcon logoRedimensionado2 = new ImageIcon(logoOriginal2.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH));
        //imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH)
        jLabel.setIcon(logoRedimensionado2); 
    //

    }


    
}
    