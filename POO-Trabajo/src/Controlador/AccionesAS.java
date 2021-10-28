
package Controlador;

import DAO.AsistenciaCRUD;
import DAO.MostrarConsulta;
import Modelo.Asistencia;
import Principal.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poo.trabajo.MarcarAsistencia;
import poo.trabajo.MarcarAsistencia_lista;


public class AccionesAS implements ActionListener{
    private MarcarAsistencia m1;
    Asistencia AS;
    public AccionesAS(MarcarAsistencia m1){
        this.m1=m1;
        this.m1.codigoasis.addActionListener(this);
        this.m1.cbxmarcacion.addActionListener(this);
        this.m1.btnconsultarasis.addActionListener(this);
        this.m1.btneliminarasis.addActionListener(this);
        this.m1.btnmodificarasis.addActionListener(this);
        this.m1.btnmostrarasis.addActionListener(this);
        this.m1.btnnuevoasis.addActionListener(this);
        this.m1.btnregistrarasis.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(m1.btnregistrarasis==e.getSource()){
            String cod=m1.codigoasis.getText();
            String m=m1.cbxmarcacion.getSelectedItem().toString();
            String h=m1.jtxtHora.getText();
            String f=m1.jtxtFecha.getText();
            Asistencia A=new Asistencia(cod,m,h,f);
            AsistenciaCRUD as= new AsistenciaCRUD();
            as.Create(A);
        }
        else if(m1.btnnuevoasis==e.getSource()){
            m1.codigoasis.setText("");
            m1.cbxmarcacion.setSelectedItem(0);
            m1.jtxtHora.setText("");
            m1.jtxtFecha.setText("");
            m1.codigoasis.requestFocus();
        }
        else if(m1.btnmostrarasis==e.getSource()){
            Main.m2=new MarcarAsistencia_lista();
            MostrarConsulta mc=new MostrarConsulta();
            mc.MostrarEnTablaAsistencia(Main.m2.tablaasis);
            Main.m2.setVisible(true);
            Main.m2.setLocationRelativeTo(null);
        }
        else if(m1.btnconsultarasis==e.getSource()){
            String DNI=JOptionPane.showInputDialog("Ingrese DNI a buscar");
            AsistenciaCRUD ac=new AsistenciaCRUD();
            AS=ac.Read(DNI);
            if(AS!=null){
                m1.codigoasis.setText(AS.codigoasis);
                m1.cbxmarcacion.setSelectedItem(AS.marcacion);
                m1.jtxtHora.setText(AS.hora);
                m1.jtxtFecha.setText(AS.fecha);
            }else{
                JOptionPane.showMessageDialog(null,"DNI buscado no existe");
            }
        }
        else if(m1.btnmodificarasis==e.getSource()){
            String cod=m1.codigoasis.getText();
            String m=m1.cbxmarcacion.getSelectedItem().toString();
            String h=m1.jtxtHora.getText();
            String f=m1.jtxtFecha.getText();             
            AS=new Asistencia(cod,m,h,f);
            AsistenciaCRUD ac= new AsistenciaCRUD();
            ac.Update(AS);
        }
        else if(m1.btneliminarasis==e.getSource()){
            int reply=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_NO_OPTION){
                AsistenciaCRUD ac= new AsistenciaCRUD();
                ac.Delete(AS.codigoasis);
            }
        }
    }
}
