package Tarea5;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class seguridad {
    FrmLogin login = new FrmLogin();
    String res;
    public void validarUsuario(String usuarios[], String user, String pw,int intentos){
        boolean encont = false;
        try{
            
     
        for(int i=0; i < usuarios.length;i++){
            if(usuarios[i].equals(user)&&usuarios[i+1].equals(pw)){
            res="Bienvenido " + user;
            encont= true;
            JOptionPane.showMessageDialog(null, res, "Inicio de Sesion ", JOptionPane.INFORMATION_MESSAGE);
            intentos=0;
            login.setIntentos(intentos);
            break;
        }
    }
    if(encont==false){
    res="clave o usuario erroneo van "+ intentos +" Intentos fallidos";
    JOptionPane.showMessageDialog(null, res, "Inicio de Sesion ", JOptionPane.ERROR_MESSAGE);
    
}if(intentos >2){

    JOptionPane.showMessageDialog(null, "3 intenos fallidos, el programa se cerrara","Inicio de sesion ",JOptionPane.ERROR_MESSAGE);
    System.exit(0);
}   }catch(Exception e){
    JOptionPane.showMessageDialog(null, res, "intenos fallidos, el programa se cerrara", JOptionPane.ERROR_MESSAGE);
}
    }
}

