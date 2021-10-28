
package ClaseReporteadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GenerarReporte {
    Connection con=null;
    public GenerarReporte(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=POO","sa","12");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"No se puede conectar a la BD..."+ex);
        }
    }
    public void MostrarReporte(String DNI){
        try{
        JasperReport reporte=(JasperReport)JRLoader.loadObject("ReportePOO.jasper");
        Map parametro=new HashMap();
        parametro.put("ls_codigo",DNI);
        JasperPrint jasperPrint=JasperFillManager.fillReport(reporte,parametro, con);
        JasperViewer jviewer=new JasperViewer(jasperPrint,false);
        jviewer.setTitle("Reporte de Detalle de Venta");
        jviewer.setVisible(true);
        }
        catch(Exception j){
            JOptionPane.showMessageDialog(null,"Error al mostrar Reporte..."+j.getMessage());
        }
    }
    public void cerrar(){
        try{
            con.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al cerrar la conexión..."+ex.getMessage());
        }
    }
    
}
