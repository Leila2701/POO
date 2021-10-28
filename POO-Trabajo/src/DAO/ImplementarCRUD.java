
package DAO;

import Modelo.Empleado;

public interface ImplementarCRUD {
    public void Create(Empleado E);//insert
    public Empleado Read(String COD_EMP);//select
    public void Update(Empleado E);//actualizar
    public void Delete(String COD_EMP);//eliminacion 
}

