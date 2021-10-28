
package Modelo;

public class Horario {
    public String codigo;
    public String horaIngreso;
    public String horaSalida;
    public String horaRefrigerio;
    public String FinRefrigerio;
   public Horario(){}
   public Horario(String c,String hi,String hs,String hr,String fr){
       this.codigo=c;
       this.horaIngreso=hi;
       this.horaSalida=hs;
       this.horaRefrigerio=hr;
       this.FinRefrigerio=fr;
   }
   public Object[] Registro(int num){
    Object[] fila={num,codigo,horaIngreso,horaSalida,horaRefrigerio,FinRefrigerio};
    return fila;
    }   
}
