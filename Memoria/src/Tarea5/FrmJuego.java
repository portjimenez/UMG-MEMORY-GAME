package Tarea5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class FrmJuego {
    
    // para laa matriz
    int a =8;
    int b =8;
    //
    JFrame ventana;
    JPanel PanelPres;
    JLabel fondo;
    JLabel botonjugar;
       Random aleatorio;
    JPanel panelJuego;
   JLabel matriz[][];
    int mat[][];
        int matAux[][];
    String Jugador;
    JLabel nombJugador;
    Timer tiempo;
           String [] as;
           JLabel cronometro;
           int min;
           int seg;
           int contador;
              Timer tiempoEspera;
              int cs;
                 int ban1=0;
   int ban=0;
     Timer tiempoEspera2;
     int n;
     int x;
     int y;
     int acx;
     int acy;
     int nn;
     
     
String []Prueba = {"1","2","3","4","5","6","7","8"};
     
     
     
     public FrmJuego(){
  // initComponents();
          // funcioness.CargarLogo(fondo, Jugador);
        //ventana
        ventana=new JFrame("Juego memoria");
        ventana.setSize(1000,900);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        
        
      //Jpanel Presentacion
       PanelPres=new JPanel();
        PanelPres.setSize(ventana.getWidth(),ventana.getHeight());
        PanelPres.setLocation(0, 0);
        PanelPres.setLayout(null);
        PanelPres.setVisible(true);
   
 //   ventana.add( PanelPres,0);
    
    //fondo
        fondo=new JLabel();
      fondo.setSize(ventana.getWidth(),ventana.getHeight());
      fondo.setLocation(0,0);
     fondo.setIcon(new ImageIcon(new ImageIcon ("./src/img/fondo.png").getImage().getScaledInstance(1000,900 , Image.SCALE_DEFAULT)));
       
      fondo.setVisible(true);
      PanelPres.add(fondo,0);
    // ventana.add(fondo,0);
      
      
      //nombre juegador
       nombJugador=new JLabel();
      nombJugador.setSize(500,30);
    nombJugador.setLocation(ventana.getWidth()-300,-15);
    nombJugador.setForeground(Color.red);
     nombJugador.setVisible(true);
      PanelPres.add(nombJugador,0);
      nombJugador.setVisible(true);
      //nombJugador=new JLabel("Juego memoria:" +Jugador);
       this.nombre();
      
      
    
      //tiempo
       cronometro=new JLabel();
      cronometro.setSize(150,70);
      Font font = cronometro.getFont();
    cronometro.setLocation(ventana.getWidth()-250,-15);
    cronometro.setForeground(Color.DARK_GRAY);
    Font normal = new Font("Arial", Font.PLAIN, 20);
  cronometro.setFont(normal);
     cronometro.setVisible(true);
      PanelPres.add(cronometro,0);
      
     

      
          mat = new int [a][b];
            matAux = new int [a][b];
          aleatorio = new Random();
          this.numeroAleatorios();
          
              
          //imagenes matriz
            matriz = new JLabel[a][b];
            for (int i = 0;i < a; i++) {
            for(int j=0; j<b;j++){
            matriz[i][j]= new JLabel();
                  // matriz[i][j].setBounds(60+(j*56),50+(i*67),56,67);
         matriz[i][j].setBounds(60+(j*78),35+(i*81),73,78);
          matriz[i][j].setIcon(new ImageIcon("./src/img/"+matAux[i][j]+".png"));

       //  matriz[i][j].setIcon(new ImageIcon("./src/img/carta.png"));
            matriz[i][j].setVisible(true);
            PanelPres.add(matriz[i][j],0);
                // cronometro.setText("Tiempo: "+min +":"+seg);
            }
            }
     
           
               //tiempo
       // tiempo = new Timer();
        min=0;
        seg=0;
       
        tiempo = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {				int option = 0;
                
                seg++;
                if(seg==60){
                    min++;
                    seg=0;
                   
                }
                if(min==3){
                     tiempo.stop();
                               JOptionPane.showMessageDialog(null,"Fin ", "El Tiempo a terminado ", JOptionPane.INFORMATION_MESSAGE);
                              FrmMenu menu = new FrmMenu();
        menu.setVisible(true);
        
                
                  	if (option == JOptionPane.INFORMATION_MESSAGE) {
			//.exit(0);
                          int DISPOSE_ON_CLOSE = WindowConstants.HIDE_ON_CLOSE;
		}
                }
          //  
                cronometro.setText("Tiempo: "+min +":"+seg);

            }


            
        });
        
         cs=0;
               tiempoEspera = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                cs ++;
                
                
            }
            
            
        });
               tiempoEspera.start();
               tiempoEspera.stop();
               cs=0;
               ban1=0;
                ban=0;
             //    tiempoEspera2.start();
            
            
             nombJugador.setText( "as " + Jugador); 
          tiempo.start();
         cronometro.setText("Tiempo: "+min +":"+seg);
          //evento de clic cartas
          
         contador =0;
        for (int i = 0; i <a; i++) {
               for (int j = 0; j <b; j++) {
                matriz[i][j].addMouseListener(new MouseAdapter(){
                    @Override
                    
  
            

                   public void mousePressed(MouseEvent e){
                 
                       
                        for (int k = 0; k < a; k++) {
                            for (int l = 0; l < b; l++) {
                                if(e.getSource()==matriz[k][l]){
                
                                                      
                                       
                          
                   
                                 if(matAux[k][l]==0 && contador!=2){
                                        matAux[k][l]=mat[k][l];
                                        matriz[k][l].setIcon(new ImageIcon(new ImageIcon("./src/img/"+ matAux[k][l]+".png").getImage().getScaledInstance(80,76 , Image.SCALE_DEFAULT)));
                                 
                                           contador++;
                                     nn= mat[k][l];
                                acx=k;
                                acy=l;
                                if(contador ==1)
                                        {
                                             n= mat[k][l];
                                           x=k;
                                           y=l;
                                           
                                                  }
                           
                             
                               
                                        }
                              
                                        
                                            tiempoEspera2 = new Timer(20, new ActionListener()
                           {
        public void actionPerformed(ActionEvent e)
           {   if(contador==2  && ban1==0){
                                   tiempoEspera.restart();
                               ban1=1;
                                         }
                                if(contador ==2 && cs==3){
                                    tiempoEspera.stop();
                                    cs=0;
                                    
                                if(matAux[acx][acy]==matAux[x][y]){
                                    
                            
                                      matAux[acx][acy]=-1;
                                     matAux[x][y]=-1;
                               matriz[acx][acy].setIcon(new ImageIcon(new ImageIcon("./src/img/"+matAux[acx][acy]+".png").getImage().getScaledInstance(80,76 , Image.SCALE_DEFAULT)));    
                                    matriz[x][y].setIcon(new ImageIcon(new ImageIcon("./src/img/"+matAux[x][y]+".png").getImage().getScaledInstance(80,76 , Image.SCALE_DEFAULT)));    
                                  contador=0;
                                  
                                  }
                                   
                                     for (int m = 0; m < a; m++) {
                                         for (int n = 0; n < b; n++) {
                                             
                                             System.out.print(matAux[m][n]+" ");  
                                             if(matAux[m][n]!= 0 && matAux[m][n]!=-1){
                                                    matAux[m][n]=0;
                                               matriz[m][n].setIcon(new ImageIcon(new ImageIcon("./src/img/"+matAux[m][n]+".png").getImage().getScaledInstance(80,76 , Image.SCALE_DEFAULT)));    
                                               contador=0;
                                             }
                                         }
                                       
                                    }
                                   tiempoEspera2.stop();
                                     ban1=0;
                               }
                          
                     }});
                         if(ban==0){
                                    
                                    tiempoEspera2.start();
                                    ban=1;
                                }
                                if(contador==2){
                                    tiempoEspera2.restart();
                                }
                                  
 
                             
                                  
                                   
                                 
                            }
 
                      
                   }
                        }  
               }});
               
               }
    }
             ventana.add(PanelPres);
            ventana.setVisible(true);
          

    }
    public void numeroAleatorios(){
      int acumulador =0;
        for (int i = 0;i < a; i++) {
            for(int j=0; j<b;j++){
                mat[i][j]= 0;
        //matAux[i][j]=0;
            }
        }

        for (int i = 0;i < a; i++) {
            for(int j=0; j<b;j++){
                mat[i][j]= aleatorio.nextInt(32)+1;
           do{
                    
            acumulador=0;
               for (int k = 0;k < a; k++) {
                 for (int l = 0;l< b; l++) {
                  if(mat[i][j]==mat[k][l]){
                      acumulador +=1;
                  }
                    
                }
                }
           
            if(acumulador==3){
                     mat[i][j]= aleatorio.nextInt(32)+1;
                      System.out.print(mat[i][j]+" ");
            }
                }while(acumulador==3);
            }
         
            }


    } String [] avatar;
       boolean log = false;
   int con =0;
         public void nombre()
            {
                  int nli=0;
        try {
            FileReader fr =null;
            File file = new File("");
            String linea;
            File f = new File("./src/base/base.txt");
            fr= new FileReader(f);
            BufferedReader br= new BufferedReader(fr);
            
            
            
            try {
                 
                while((linea=br.readLine())!=null){
                    avatar= linea.split(", ");
                    //String ass= Jugador;
                    if(nombJugador.equals(avatar[0])){
                         // JOptionPane.showMessageDialog(null, res, "Inicio de Sesion ", JOptionPane.INFORMATION_MESSAGE);
   // System.out.println("logueo bueno paps");
      log = true;
            FrmJuego jue=  new  FrmJuego();
            //jue.setVisible(true);
         
      
    
  }  
  nli++;
}
if(log == false){
 // JOptionPane.showMessageDialog(null, res, "Inicio de Sesion ", JOptionPane.ERROR_MESSAGE);
 //System.out.println("f");
 con++;
}

    
            } catch (IOException ex) {
                Logger.getLogger(FrmJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
 } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
         
}