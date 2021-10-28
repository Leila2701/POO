
package Modelo;

import java.util.Date;

public class Empleado {
    public String apellido;
    public String nombre;
    public String fechanacimiento;
    public String dni;
    public String direccion;
    public String telefono;
    public Empleado(){ }
    public Empleado(String a,String n,String f,String dni,String d,String t){
        this.apellido=a;
        this.nombre=n;
        this.fechanacimiento=f;
        this.dni=dni;
        this.direccion=d;
        this.telefono=t;
    }
       
}
