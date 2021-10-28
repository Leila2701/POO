package Modelo;

public class Permiso {
    public String dni;
    public String fecha;
    public String tiempo;
    public String descripcion;
    public Permiso(){}
    public Permiso(String dni,String f,String t,String d){
        this.dni=dni;
        this.fecha=f;
        this.tiempo=t;
        this.descripcion=d;
    }
    public Object[] Registro(int num){
    Object[] fila={num,dni,fecha,tiempo,descripcion};
    return fila;
    }
}
