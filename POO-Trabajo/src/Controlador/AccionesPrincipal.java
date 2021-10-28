
package Controlador;


import ClaseReporteadores.GenerarReporte;
import static Principal.Main.h1;
import static Principal.Main.l1;
import static Principal.Main.m1;
import static Principal.Main.pr;
import static Principal.Main.r1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poo.trabajo.FrmPrincipal;
import poo.trabajo.HorarioEmpleado;
import poo.trabajo.LaboresEmpleado;
import poo.trabajo.MarcarAsistencia;
import poo.trabajo.PermisoEmpleado;
import poo.trabajo.RegistroEmpleado;

public class AccionesPrincipal implements ActionListener{
    private FrmPrincipal fp;
    public AccionesPrincipal(FrmPrincipal fp){
        this.fp=fp;
        fp.jmnRegistroempleado.addActionListener(this);
        fp.jmnRegistroCargo.addActionListener(this);
        fp.jmnProgramarHorario.addActionListener(this);
        fp.jmnPermisoempleado.addActionListener(this);
        fp.jmnMarcarAsistencia.addActionListener(this);
        fp.jbtnReporte.addActionListener(this);
        fp.jmSalir.addActionListener(this);
    }
     public static Acciones acc;
     public static AccionesL acl;
     public static AccionesH ach;
     public static AccionesPermiso acp;
     public static AccionesAS aca;
    public void actionPerformed(ActionEvent e){
        if(fp.jmnRegistroempleado== e.getSource()){
            r1 = new RegistroEmpleado();
            r1.setVisible(true);
            r1.setLocationRelativeTo(null);
            acc = new Acciones(r1);
        }
        else if(fp.jmnProgramarHorario==e.getSource()){
            h1=new HorarioEmpleado();
            h1.setVisible(true);
            h1.setLocationRelativeTo(null);
            ach=new AccionesH(h1);
        }
        else if(fp.jmnRegistroCargo==e.getSource()){
            l1=new LaboresEmpleado();
            l1.setVisible(true);
            l1.setLocationRelativeTo(null);
            acl=new AccionesL(l1);
        }
        else if(fp.jmnMarcarAsistencia==e.getSource()){
            m1=new MarcarAsistencia();
            m1.setVisible(true);
            m1.setLocationRelativeTo(null);
            aca=new AccionesAS(m1);
            
        }
        else if(fp.jmnPermisoempleado==e.getSource()){
            pr=new PermisoEmpleado();
            pr.setVisible(true);
            pr.setLocationRelativeTo(null);
            acp= new AccionesPermiso(pr);
        }
        else if(fp.jbtnReporte==e.getSource()){
            GenerarReporte nr;
            nr=new GenerarReporte();
            String DNI=JOptionPane.showInputDialog("Ingresar DNI del empleado: ");
            nr.MostrarReporte(DNI);
        }
        else if(fp.jmSalir==e.getSource()){
            System.exit(0);
        }
    }
}
