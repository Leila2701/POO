
package Controlador;

import DAO.EmpleadoCRUD;
import DAO.MostrarConsulta;
import Modelo.Empleado;
import Principal.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import poo.trabajo.RegistroEmpleado;
import poo.trabajo.Registro_empleado_lista;
import ClaseReporteadores.GenerarReporte;

public class Acciones implements ActionListener{
    private RegistroEmpleado r1;
    Empleado EM;
    public Acciones(RegistroEmpleado r1){
        this.r1=r1;
        this.r1.jbtnRegistrar.addActionListener(this);
        this.r1.jbtnNuevo.addActionListener(this);
        this.r1.jbtnMostrar.addActionListener(this);
        this.r1.jbtnConsultar.addActionListener(this);
        this.r1.jbtnModificar.addActionListener(this);
        this.r1.jbtnEliminar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(r1.jbtnRegistrar== e.getSource()){
            String a=r1.jtxtApellido.getText();
            String n=r1.jtxtNombre.getText();
            //SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
            //String f=formatoFecha.format(r1.jdFecha.getDate());
            String f=r1.jtxFecha.getText();
            String dni=r1.jtxtDNI.getText();
            String d=r1.jtxtDireccion.getText();
            String t=r1.jtxtTelefono.getText();
            
            Empleado E=new Empleado(a,n,f,dni,d,t);
            EmpleadoCRUD ec= new EmpleadoCRUD();
            ec.Create(E);
        }
        else if(r1.jbtnNuevo==e.getSource()){
            r1.jtxtApellido.setText("");
            r1.jtxtNombre.setText("");
            //r1.jdFecha.setDate(String);
            //SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
            //String f=formatoFecha.format(r1.jdFecha.getDate());
            r1.jtxFecha.setText("");
            r1.jtxtDNI.setText("");
            r1.jtxtDireccion.setText("");
            r1.jtxtTelefono.setText("");
            r1.jtxtApellido.requestFocus();
        }
        else if(r1.jbtnMostrar==e.getSource()){
            Main.r2=new Registro_empleado_lista();
            MostrarConsulta mc = new MostrarConsulta();
            mc.MostrarEnTabla(Main.r2.jtblDatos);
            Main.r2.setVisible(true);
            Main.r2.setLocationRelativeTo(null);
        }
        else if(r1.jbtnConsultar==e.getSource()){
            String DNI=JOptionPane.showInputDialog("Ingrese DNI a buscar");
            EmpleadoCRUD ec= new EmpleadoCRUD();
            EM=ec.Read(DNI);
            if(EM!=null){
                r1.jtxtApellido.setText(EM.apellido);
                r1.jtxtNombre.setText(EM.nombre);
                //r1.jdFecha.setDate(String.valueOf(EM.fechanacimiento));
                //String f=formatoFecha.format(r1.jdFecha.getDate());
                //r1.jdFecha.setDate(EM.fechanacimiento);//
                r1.jtxFecha.setText(EM.fechanacimiento);
                r1.jtxtDNI.setText(EM.dni);
                r1.jtxtDireccion.setText(EM.direccion);
                r1.jtxtTelefono.setText(EM.telefono);
            }else{
                JOptionPane.showMessageDialog(null,"DNI buscado no existe");
            }
        }
        else if(r1.jbtnModificar==e.getSource()){
            String a=r1.jtxtApellido.getText();
            String n=r1.jtxtNombre.getText();
            String f=r1.jtxFecha.getText();
            String dni=r1.jtxtDNI.getText();
            String d=r1.jtxtDireccion.getText();
            String t=r1.jtxtTelefono.getText();
            
            EM=new Empleado(a,n,f,dni,d,t);
            EmpleadoCRUD ec= new EmpleadoCRUD();
            ec.Update(EM);
        }
        else if(r1.jbtnEliminar==e.getSource()){
            int reply=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_NO_OPTION){
                EmpleadoCRUD ec= new EmpleadoCRUD();
                ec.Delete(EM.dni);
            }
        }
   
}
}
