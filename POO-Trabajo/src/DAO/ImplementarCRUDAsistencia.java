
package DAO;

import Modelo.Asistencia;


public interface ImplementarCRUDAsistencia {
    public void Create(Asistencia A);
    public Asistencia Read(String DNI);
    public void Update(Asistencia A);
    public void Delete(String DNI);
}
