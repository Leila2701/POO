
package DAO;

import Modelo.Horario;

public interface ImplementarCRUDHORARIO {
    public void Create(Horario H);
    public Horario Read(String DNI);
    public void Update(Horario H);
    public void Delete(String DNI);
}
