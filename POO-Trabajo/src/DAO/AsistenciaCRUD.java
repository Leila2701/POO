
package DAO;

import Modelo.Asistencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class AsistenciaCRUD {
    Connection con;
    AccesoBD c;
    Statement st;
    ResultSet rs;
    public AsistenciaCRUD(){
        c = new AccesoBD();
        con=c.con;
    }
    public void Create(Asistencia A) {
    try{
        st =con.createStatement();
        rs = st.executeQuery("INSERT INTO ASISTENCIA(MARCACION,HORA,FECHA,DNI) VALUES ('"+A.marcacion+"','"+A.hora+"','"+A.fecha+"','"+A.codigoasis+"');");
      
    }catch(Exception e){
         AccesoBD.Mensaje("Datos registrados correctamente "+e);
    }
    }
    public Asistencia Read(String DNI) {
        Asistencia asis=null;
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT DNI,MARCACION,HORA,FECHA FROM ASISTENCIA WHERE DNI='"+DNI+"';");
            
            if(rs.next()){ 
            String cod=rs.getString(1);
            String m=rs.getString(2);
            String h=rs.getString(3);
            String f=rs.getString(4);
            asis =  new Asistencia(cod,m,h,f);
            }
        }catch(Exception e){
         AccesoBD.Mensaje("Error al recuperar "+e);
        }
        return asis;
    }
    public void Update(Asistencia A) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("UPDATE ASISTENCIA SET DNI='"+A.codigoasis+"',MARCACION='"+A.marcacion+"',HORA='"+A.hora+"', FECHA='"+A.fecha+"' WHERE DNI='"+A.codigoasis+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Guardados...");
        }
    }
    public void Delete(String DNI) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("DELETE FROM ASISTENCIA WHERE DNI='"+DNI+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Eliminado...");
        }
    }
    //falta eliminar, tambien falta en la base de datos leila;
}
