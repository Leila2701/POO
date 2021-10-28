
package DAO;

import Modelo.Permiso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class PermisoCRUD implements ImplementarCRUDPERMISO{
   Connection con;
   AccesoBD c;
   Statement st;
   ResultSet rs;
   
   public PermisoCRUD(){
        c = new AccesoBD();
        con=c.con;
    }
   public void Create(Permiso P) {
    try{
        st =con.createStatement();
        rs = st.executeQuery("INSERT INTO PERMISOS(FECHA_PERMISO,TIEMPO,DESCRIPCION,DNI)VALUES('"+P.fecha+"','"+P.tiempo+"','"+P.descripcion+"','"+P.dni+"');");
      
    }catch(Exception e){
         AccesoBD.Mensaje("Datos registrados correctamente "+e);
    }
    }

    public Permiso Read(String DNI) {
        Permiso prm=null;
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT DNI,FECHA_PERMISO, TIEMPO,DESCRIPCION FROM PERMISOS WHERE DNI='"+DNI+"';");
            
            if(rs.next()){ // verificamos la existencia de un registro
            //recuperamos cada columna del registro y cremos el objeto
            String dni=rs.getString(1);
            String f=rs.getString(2);
            String t=rs.getString(3);
            String d=rs.getString(4);
            prm=  new Permiso(dni,f,t,d);
            }
        }catch(Exception e){
         AccesoBD.Mensaje("Error al recuperar "+e);
        }
        return prm;
    }

    public void Update(Permiso P) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("UPDATE PERMISOS SET DNI='"+P.dni+"',FECHA_PERMISO= '"+P.fecha+"', TIEMPO='"+P.tiempo+"', DESCRIPCION='"+P.descripcion+"' WHERE DNI='"+P.dni+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Guardados...");
        }
    }
    
    public void Delete(String DNI) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("DELETE FROM PERMISOS WHERE DNI='"+DNI+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Eliminado...");
        }
    }

}
