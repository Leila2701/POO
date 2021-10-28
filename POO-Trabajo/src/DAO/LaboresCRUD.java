
package DAO;

import Modelo.Labores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LaboresCRUD implements ImplementarCRUDLabores {
    Connection con;
    AccesoBD c;
    Statement st;
    ResultSet rs;
    public LaboresCRUD(){
        c = new AccesoBD();
        con=c.con;
    }
    public void Create(Labores L) {
    try{
        st =con.createStatement();
        rs = st.executeQuery("INSERT INTO LABORES (CARGO,DNI) VALUES ('"+L.actividad+"','"+L.codigolab+"');");
      
    }catch(Exception e){
         AccesoBD.Mensaje("Datos registrados correctamente "+e);
    }
    }


    public Labores Read(String DNI) {
        Labores lab=null;
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT  DNI, CARGO FROM LABORES  WHERE DNI='"+DNI+"';");
            
            if(rs.next()){ // verificamos la existencia de un registro
            //recuperamos cada columna del registro y cremos el objeto
            String codlab=rs.getString(1);
            String a=rs.getString(2);
            lab =  new Labores(codlab,a);
            }
        }catch(Exception e){
         AccesoBD.Mensaje("Error al recuperar "+e);
        }
        return lab;
    }

    public void Update(Labores L) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("UPDATE LABORES SET DNI='"+L.codigolab+"', CARGO='"+L.actividad+"' WHERE DNI='"+L.codigolab+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Guardados...");
        }
    }

    
    public void Delete(String DNI) {
        try{
            st=con.createStatement();
            rs=st.executeQuery("DELETE FROM LABORES WHERE DNI='"+DNI+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Eliminado...");
        }
    }
}
