
package DAO;

import Principal.Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarConsulta {
    Connection con;
    Statement st;
    ResultSet rs;
    AccesoBD c;
    public MostrarConsulta(){
        c=new AccesoBD(); //crea la conexion
        con=c.con; // actualizamos la conexion
    }
    public void MostrarEnTabla(JTable tabla){
        String[] encab1 = {"Num","Apellidos","Nombres","Fecha de Nacimiento","DNI","Direccion","Telefono"};
        DefaultTableModel mt = new DefaultTableModel(null,encab1);
        tabla.setModel(mt); 
    int contador=0;
    try{
           st = con.createStatement(); // crea el espacio para la consulta
           //ejecuta la consulta en un String
           rs = st.executeQuery("SELECT*FROM EMPLEADOS");
           while(rs.next()){ // recorre por filas
               contador++;
               Object[] fila={contador,rs.getString(1),rs.getString(2),rs.getString(3),
                     rs.getString(4),rs.getString(5),rs.getString(6)};
               mt.addRow(fila);
           }
        }catch(Exception e){
        AccesoBD.Mensaje("Error al cargar data "+e);
    }
    }
    
    public void MostrarEnTablaLabores(JTable tabla){
        String[] encab2 = {"Num","APELLIDO","NOMBRE","DNI","CARGO"};
        DefaultTableModel ms = new DefaultTableModel(null,encab2);
        tabla.setModel(ms); 
    int contador=0;
    try{
           st = con.createStatement(); // crea el espacio para la consulta
           //ejecuta la consulta en un String
           rs = st.executeQuery("SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, LABORES.DNI, LABORES.CARGO FROM EMPLEADOS INNER JOIN LABORES ON EMPLEADOS.DNI=LABORES.DNI; ");
           while(rs.next()){ // recorre por filas
               contador++;
               Object[] fila={contador,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
               ms.addRow(fila);
           }
        }catch(Exception e){
        AccesoBD.Mensaje("Error al cargar data "+e);
    }
    }
    public void MostrarEnTablaHorario(JTable tabla){
        String[] encab3 = {"Num","APELLIDO","NOMBRE","DNI","HORA DE INGRESO","HORA DE SALIDA","HORA DE REFRIGERIO","FIN DE REFRIGERIO"};
        DefaultTableModel mh = new DefaultTableModel(null,encab3);
        tabla.setModel(mh); 
    int contador=0;
    try{
           st = con.createStatement(); // crea el espacio para la consulta
           //ejecuta la consulta en un String
           rs = st.executeQuery("SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, HORARIO.DNI,HORARIO.HORA_INGRESO,HORARIO.HORA_SALIDA,HORARIO.HORA_REFRIGRERIO,HORARIO.FIN_REFRIGERIO FROM EMPLEADOS INNER JOIN HORARIO ON EMPLEADOS.DNI=HORARIO.DNI;");
           while(rs.next()){ // recorre por filas
               contador++;
               Object[] fila={contador,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
               mh.addRow(fila);
           }
        }catch(Exception e){
        AccesoBD.Mensaje("Error al cargar data "+e);
    }
    }
    public void MostrarEnTablaPermiso(JTable tabla){
        String[] encab4 = {"Num","APELLIDOS","NOMBRE","DNI","FECHA PERMISO","TIEMPO","DESCRIPCIÓN"};
        DefaultTableModel mp = new DefaultTableModel(null,encab4);
        tabla.setModel(mp); 
    int contador=0;
    try{
           st = con.createStatement(); // crea el espacio para la consulta
           //ejecuta la consulta en un String
           rs = st.executeQuery("SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, PERMISOS.DNI,PERMISOS.FECHA_PERMISO,PERMISOS.TIEMPO,PERMISOS.DESCRIPCION FROM EMPLEADOS INNER JOIN PERMISOS ON EMPLEADOS.DNI=PERMISOS.DNI;");
           while(rs.next()){ // recorre por filas
               contador++;
               Object[] fila={contador,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
               mp.addRow(fila);
           }
        }catch(Exception e){
        AccesoBD.Mensaje("Error al cargar data "+e);
    }
    }
    public void MostrarEnTablaAsistencia(JTable tabla){
        String[] encab5={"Num","APELLIDOS","NOMBRES","DNI","FECHA","HORA","MARCACION"};
        DefaultTableModel ma=new DefaultTableModel(null,encab5);
        tabla.setModel(ma);
        int contador=0;
        try {
            st=con.createStatement();// crea el espacio para la consulta
            //ejecuta la consulta en un String
            rs=st.executeQuery("SELECT EMPLEADOS.APELLIDO, EMPLEADOS.NOMBRE, ASISTENCIA.DNI, ASISTENCIA.FECHA,ASISTENCIA.HORA,ASISTENCIA.MARCACION FROM EMPLEADOS INNER JOIN ASISTENCIA ON EMPLEADOS.DNI=ASISTENCIA.DNI;");
            while(rs.next()){
                contador++;
                Object[] fila={contador,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                ma.addRow(fila);
            }
        } catch (Exception e) {
            AccesoBD.Mensaje("Error al cargar data "+e);
        }
    }
}
