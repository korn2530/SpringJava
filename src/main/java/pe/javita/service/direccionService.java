
package pe.javita.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.javita.dao.DireccionDao;
import pe.javita.dao.adminDao;
import pe.javita.pojo.Admin;
import pe.javita.pojo.Direccion;

@Service
public class direccionService {
    
    @Autowired
    private DireccionDao direccionDao;
    
    @Autowired
    private adminDao adDao;
    
    public void save(Admin admin,Direccion direccion){
        direccion.setAdmin(admin);
        direccionDao.save(direccion);
      
    }
    
    public List<Direccion> findAll(int idAd){
        
       return direccionDao.findById(idAd);
             
    }
    
}
