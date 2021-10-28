
package DAO;

import Modelo.Labores;

public interface ImplementarCRUDLabores {
    public void Create(Labores L);
    public Labores Read(String DNI);
    public void Update(Labores L);
    public void Delete(String DNI);
}
