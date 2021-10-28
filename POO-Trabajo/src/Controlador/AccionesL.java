
package Controlador;

import DAO.LaboresCRUD;
import DAO.MostrarConsulta;
import Modelo.Labores;
import Principal.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poo.trabajo.LaboresEmpleado;
import poo.trabajo.LaboresEmpleado_lista;

public class AccionesL implements ActionListener{
    private LaboresEmpleado l1;
    Labores LA;
    public AccionesL(LaboresEmpleado l1){
        this.l1=l1;
        this.l1.jbtnGuardar.addActionListener(this);
        this.l1.jbtnNuevo.addActionListener(this);
        this.l1.jbtnMostar.addActionListener(this);
        this.l1.jbtnConsultar.addActionListener(this);
        this.l1.jbtnModificar.addActionListener(this);
        this.l1.jbtnEliminar.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(l1.jbtnGuardar==e.getSource()){
            String cod=l1.jtxtCodigoLabores.getText();
            String a=l1.jcbxActividad.getSelectedItem().toString();  
            Labores L=new Labores(cod,a);
            LaboresCRUD ec= new LaboresCRUD();
            ec.Create(L);
        }
        else if(l1.jbtnNuevo==e.getSource()){
            l1.jtxtCodigoLabores.setText("");
            l1.jcbxActividad.setSelectedIndex(0);
            l1.jtxtCodigoLabores.requestFocus();
        }
        else if(l1.jbtnMostar==e.getSource()){
            Main.l2=new LaboresEmpleado_lista();
            MostrarConsulta mc = new MostrarConsulta();
            mc.MostrarEnTablaLabores(Main.l2.jtblDatosActividad);
            Main.l2.setVisible(true);
            Main.l2.setLocationRelativeTo(null);
        }
        else if(l1.jbtnConsultar==e.getSource()){
            String DNI=JOptionPane.showInputDialog("Ingrese DNI a buscar");
            LaboresCRUD ec= new LaboresCRUD();
            LA=ec.Read(DNI);
            if(LA!=null){
                l1.jtxtCodigoLabores.setText(LA.codigolab);
                l1.jcbxActividad.setSelectedItem(LA.actividad);
            }else{
                JOptionPane.showMessageDialog(null,"DNI buscado no existe");
            }
        }
        else if(l1.jbtnModificar==e.getSource()){
            String cod=l1.jtxtCodigoLabores.getText();
            String a=l1.jcbxActividad.getSelectedItem().toString();            
            LA=new Labores(cod,a);
            LaboresCRUD ec= new LaboresCRUD();
            ec.Update(LA);
        }
        else if(l1.jbtnEliminar==e.getSource()){
            int reply=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?","CONFIRMAR",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_NO_OPTION){
                LaboresCRUD ec= new LaboresCRUD();
                ec.Delete(LA.codigolab);
            }
        }
        
    }
}
