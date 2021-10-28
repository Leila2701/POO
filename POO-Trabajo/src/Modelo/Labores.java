
package Modelo;

public class Labores {
    public String codigolab;
    public String actividad;
    public Labores(){}
    public Labores(String cod,String a){
        this.codigolab=cod;
        this.actividad=a;
    }
    public Object[] Registro(int num){
    Object[] fila={num,codigolab,actividad};
    return fila;
    }
}
