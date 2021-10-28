package Controlador;

import DAO.HorarioCRUD;
import DAO.MostrarConsulta;
import Modelo.Horario;
import Principal.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poo.trabajo.HorarioEmpleado;
import poo.trabajo.HorarioEmpleado_lista;

public class AccionesH implements ActionListener{
    private HorarioEmpleado h1;
    Horario HO;
    public AccionesH(HorarioEmpleado h1){
        this.h1=h1;
        this.h1.jbtnRegistrarHorario.addActionListener(this);
        this.h1.jbtnNuevoHorario.addActionListener(this);
        this.h1.jbtnMostrarHorario.addActionListener(this);
        this.h1.jbtnConsultarHorario.addActionListener(this);
        this.h1.jbtnModificarHorario.addActionListener(this);
        this.h1.jbtnEliminarHorario.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(h1.jbtnRegistrarHorario==e.getSource()){
            String c=h1.jtxtCodigohorario.getText();
            String hi=h1.jtxtIngreso.getText();
            String hs=h1.jtxtSalida.getText();
            String hr=h1.jtxtInicioRefrigerio.getText();
            String fr=h1.jtxtFinRefrigerio.getText();
            
            Horario H=new Horario(c,hi,hs,hr,fr);
            HorarioCRUD ec= new HorarioCRUD();
            ec.Create(H);
        }
        else if(h1.jbtnNuevoHorario==e.getSource()){
            h1.jtxtCodigohorario.setText("");
            h1.jtxtIngreso.setText("");
            h1.jtxtSalida.setText("");
            h1.jtxtInicioRefrigerio.setText("");
            h1.jtxtFinRefrigerio.setText("");
            h1.jtxtCodigohorario.requestFocus();
        }
        else if(h1.jbtnMostrarHorario==e.getSource()){
            Main.h2=new HorarioEmpleado_lista();
            MostrarConsulta mc = new MostrarConsulta();
            mc.MostrarEnTablaHorario(Main.h2.jtblDatosHorario);
            Main.h2.setVisible(true);
            Main.h2.setLocationRelativeTo(null);
            
        }
                else if(h1.jbtnConsultarHorario==e.getSource()){
            String DNI=JOptionPane.showInputDialog("Ingrese DNI a buscar");
            HorarioCRUD ec= new HorarioCRUD();
            HO=ec.Read(DNI);
            if(HO!=null){
                h1.jtxtCodigohorario.setText(HO.codigo);
                h1.jtxtIngreso.setText(HO.horaIngreso);
                h1.jtxtSalida.setText(HO.horaSalida);
                h1.jtxtInicioRefrigerio.setText(HO.horaRefrigerio);
                h1.jtxtFinRefrigerio.setText(HO.FinRefrigerio);
               
            }else{
                JOptionPane.showMessageDialog(null,"DNI buscado no existe");
            }
        }
        else if(h1.jbtnModificarHorario==e.getSource()){
            String c=h1.jtxtCodigohorario.getText();
            String hi=h1.jtxtIngreso.getText();
            String hs=h1.jtxtSalida.getText();
            String hr=h1.jtxtInicioRefrigerio.getText();
            String fr=h1.jtxtFinRefrigerio.getText();  
            HO=new Horario(c,hi,hs,hr,fr);
            HorarioCRUD ec= new HorarioCRUD();
            ec.Update(HO);
        }
        else if(h1.jbtnEliminarHorario==e.getSource()){
            int reply=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_NO_OPTION){
                HorarioCRUD ec= new HorarioCRUD();
                ec.Delete(HO.codigo);
            }
 
       

    }
}
}