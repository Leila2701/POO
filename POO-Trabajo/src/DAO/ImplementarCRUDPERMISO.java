
package DAO;

import Modelo.Permiso;

public interface ImplementarCRUDPERMISO {
    public void Create(Permiso P);
    public Permiso Read(String DNI);
    public void Update(Permiso P);
    public void Delete(String DNI);
}
