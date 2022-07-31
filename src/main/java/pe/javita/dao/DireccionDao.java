
package pe.javita.dao;

import java.util.List;
import pe.javita.pojo.Admin;
import pe.javita.pojo.Direccion;


public interface DireccionDao {
    
    void save(Direccion direccion);
    List<Direccion> findById(int id);
    
}
