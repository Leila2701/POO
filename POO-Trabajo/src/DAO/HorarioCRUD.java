
package DAO;

import Modelo.Horario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HorarioCRUD implements ImplementarCRUDHORARIO {
    Connection con;
    AccesoBD c;
    Statement st;
    ResultSet rs;
    
    public HorarioCRUD(){
        c = new AccesoBD();
        con=c.con;
    }
    
    public void Create(Horario H) {
    try{
        st =con.createStatement();
        rs = st.executeQuery("INSERT INTO HORARIO(DNI,HORA_INGRESO,HORA_SALIDA,HORA_REFRIGRERIO,FIN_REFRIGERIO) VALUES('"+H.codigo+"','"+H.horaIngreso+"','"+H.horaSalida+"','"+H.horaRefrigerio+"','"+H.FinRefrigerio+"');");
      
    }catch(Exception e){
         AccesoBD.Mensaje("Datos registrados correctamente "+e);
    }
    }


   
    public Horario Read(String DNI) {
          Horario hor=null;
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT DNI,HORA_INGRESO,HORA_SALIDA,HORA_REFRIGRERIO,FIN_REFRIGERIO FROM HORARIO WHERE DNI='"+DNI+"';");
            if(rs.next()){ // verificamos la existencia de un registro
            //recuperamos cada columna del registro y cremos el objeto
             String c=rs.getString(1);
            String hi=rs.getString(2);
            String hs=rs.getString(3);
            String hr=rs.getString(4);
            String fr=rs.getString(5);
            hor=new Horario(c,hi,hs,hr,fr);
            }
        }catch(Exception e){
         AccesoBD.Mensaje("Error al recuperar "+e);
        }
        return hor;
    }

   
    public void Update(Horario H) {
       try{
            st=con.createStatement();
            rs=st.executeQuery("UPDATE HORARIO SET DNI='"+H.codigo+"', HORA_INGRESO='"+H.horaIngreso+"', HORA_SALIDA='"+H.horaSalida+"',HORA_REFRIGRERIO='"+H.horaRefrigerio+"',FIN_REFRIGERIO='"+H.FinRefrigerio+"' WHERE DNI='"+H.codigo+"';");
        }catch(Exception e){            
            AccesoBD.Mensaje("Dato Guardados...");
        }
    }

    
    public void Delete(String DNI) {
       try{
            st=con.createStatement();
            rs=st.executeQuery("DELETE FROM HORARIO WHERE DNI='"+DNI+"';");
        }catch(Exception e){
            AccesoBD.Mensaje("Dato Eliminado...");
        }
    }
}
