
package DAO;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class EmpleadoCRUD implements ImplementarCRUD {
    Connection con;
    AccesoBD c;
    Statement st;
    ResultSet rs;
    
    public EmpleadoCRUD(){
        c = new AccesoBD();
        con=c.con;
    }
    
    public void Create(Empleado E) {
    try{
        st =con.createStatement();
        rs = st.executeQuery("INSERT INTO EMPLEADOS(APELLIDO,NOMBRE,FECHANAC,DNI,DIRECCION,TELEFONO) VALUES('"+E.apellido+"','"+E.nombre+"','"+E.fechanacimiento+"','"+E.dni+"','"+E.direccion+"','"+E.telefono+"');");
      
    }catch(Exception e){
         AccesoBD.Mensaje("Datos registrados correctamente "+e);
    }
    }

   
    public Empleado Read(String DNI) {
        Empleado emp=null;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT APELLIDO,NOMBRE,FECHANAC,DNI,DIRECCION,TELEFONO FROM EMPLEADOS WHERE DNI='"+DNI+"';");
            if(rs.next()){
                String a=rs.getString(1);
                String n=rs.getString(2);
                String f=rs.getString(3);
                String dni=rs.getString(4);
                String d=rs.getString(5);
                String t=rs.getString(6);
                emp=new Empleado(a,n,f,dni,d,t);
            }
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Guardados...");
        }
        return emp;
    }

    
    public void Update(Empleado E) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("UPDATE EMPLEADOS SET APELLIDO='"+E.apellido+"', NOMBRE='"+E.nombre+"',FECHANAC='"+E.fechanacimiento+"',DNI='"+E.dni+"',DIRECCION='"+E.direccion+"',TELEFONO='"+E.telefono+"' WHERE DNI='"+E.dni+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Guardados...");
        }
        
    }

    
    public void Delete(String DNI) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("DELETE FROM EMPLEADOS WHERE DNI='"+DNI+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Eliminado...");
        }
    }

    
}
