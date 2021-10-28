
package Principal;


import Controlador.AccionesLogin;
import DAO.MostrarConsulta;
import poo.trabajo.FrmPrincipal;
import poo.trabajo.HorarioEmpleado;
import poo.trabajo.HorarioEmpleado_lista;
import poo.trabajo.LaboresEmpleado;
import poo.trabajo.LaboresEmpleado_lista;
import poo.trabajo.Login;
import poo.trabajo.MarcarAsistencia;
import poo.trabajo.MarcarAsistencia_lista;
import poo.trabajo.PermisoEmpleado;
import poo.trabajo.PermisoEmpleado_lista;
import poo.trabajo.RegistroEmpleado;
import poo.trabajo.Registro_empleado_lista;


public class Main {
    public static RegistroEmpleado r1;
    public static Registro_empleado_lista r2;
    
    public static HorarioEmpleado h1;
    public static HorarioEmpleado_lista h2;

    public static LaboresEmpleado l1;
    public static LaboresEmpleado_lista l2;
    
    public static MostrarConsulta ml;    
    
    public static FrmPrincipal fp;
    
    public static MarcarAsistencia m1;
    public static MarcarAsistencia_lista m2;
    
    public static PermisoEmpleado pr;
    public static PermisoEmpleado_lista pr2;
    
    public static Login ls;
    
    public static void main(String[] args) {
        
        ls=new Login();
        ls.setVisible(true);
        ls.setLocationRelativeTo(null);
        ls.setLocationRelativeTo(null);
        AccionesLogin s=new AccionesLogin(ls);
    }
}

