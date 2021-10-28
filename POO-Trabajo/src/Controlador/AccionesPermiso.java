
package Controlador;

import DAO.MostrarConsulta;
import DAO.PermisoCRUD;
import Modelo.Permiso;
import Principal.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import poo.trabajo.PermisoEmpleado;
import poo.trabajo.PermisoEmpleado_lista;

public class AccionesPermiso implements ActionListener{
    private PermisoEmpleado pr;
    Permiso P;
    public AccionesPermiso(PermisoEmpleado pr){
        this.pr=pr;
        this.pr.jbtnRegistrar.addActionListener(this);
        this.pr.jbtnNuevo.addActionListener(this);
        this.pr.jbtnMostrar.addActionListener(this);
        this.pr.jbtnConsultar.addActionListener(this);
        this.pr.jbtnModificar.addActionListener(this);
        this.pr.jbtneliminar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(pr.jbtnRegistrar==e.getSource()){
            String dni=pr.jtxtdni.getText();
            String f=pr.jtxFechaPermiso.getText();
            String t=pr.jtxtTiempo.getText();
            String d=pr.jtxtDescripcion.getText();
            
            Permiso P=new Permiso(dni,f,t,d);
            PermisoCRUD ec= new PermisoCRUD();
            ec.Create(P);
        }
        else if(pr.jbtnNuevo==e.getSource()){
            pr.jtxtdni.setText("");
            pr.jtxFechaPermiso.setText("");
            pr.jtxtTiempo.setText("");
            pr.jtxtDescripcion.setText("");
        }
        else if(pr.jbtnMostrar==e.getSource()){
            Main.pr2=new PermisoEmpleado_lista();
            MostrarConsulta mc = new MostrarConsulta();
            mc.MostrarEnTablaPermiso(Main.pr2.jtblDatosPermiso);
            Main.pr2.setVisible(true);
            Main.pr2.setLocationRelativeTo(null);
            
        }
        else if(pr.jbtnConsultar==e.getSource()){
            String DNI=JOptionPane.showInputDialog("Ingrese DNI a buscar");
            PermisoCRUD ec= new PermisoCRUD();
            P=ec.Read(DNI);
            if(P!=null){
                pr.jtxtdni.setText(P.dni);
                pr.jtxFechaPermiso.setText(P.fecha);
                pr.jtxtTiempo.setText(P.tiempo);
                pr.jtxtDescripcion.setText(P.descripcion);
            }else{
                JOptionPane.showMessageDialog(null,"DNI buscado no existe");
            }
        }
        else if(pr.jbtnModificar==e.getSource()){
            String dni=pr.jtxtdni.getText();
            String f=pr.jtxFechaPermiso.getText();
            String t=pr.jtxtTiempo.getText();
            String d=pr.jtxtDescripcion.getText();            
            P=new Permiso(dni,f,t,d);
            PermisoCRUD ec= new PermisoCRUD();
            ec.Update(P);
        }
        else if(pr.jbtneliminar==e.getSource()){
            int reply=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_NO_OPTION){
                PermisoCRUD ec= new PermisoCRUD();
                ec.Delete(P.dni);
            }
        }
        
    }
}
