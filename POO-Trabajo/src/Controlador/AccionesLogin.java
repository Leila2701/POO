/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.AccionesPrincipal.acc;
import static Principal.Main.fp;
import static Principal.Main.r1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poo.trabajo.FrmPrincipal;
import poo.trabajo.Login;
import poo.trabajo.RegistroEmpleado;

public class AccionesLogin implements ActionListener{
         private Login ls;
         public AccionesLogin(Login ls){
             this.ls=ls;
             ls.jbtnIngresar.addActionListener(this);
         }
         
         public void actionPerformed(ActionEvent e){
             String Pass=new String (ls.Password.getPassword());
            String usuario="admin";
            String contraseña="12345678";
             if(ls.jtxtUsuario.getText().equalsIgnoreCase(usuario)&& Pass.equals(contraseña)){
                if(ls.jbtnIngresar==e.getSource()){
                    fp=new FrmPrincipal();
                    fp.setVisible(true);
                    fp.setLocationRelativeTo(null);
                    fp.setLocationRelativeTo(null);
                    AccionesPrincipal p=new AccionesPrincipal(fp);
                }
            }
         }    
}
  
 

