
package pe.javita.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.javita.pojo.Admin;


import pe.javita.pojo.Direccion;


@Repository
@Transactional
public class DireccionDaoImpl implements DireccionDao{
    
    @Autowired
    SessionFactory sessionFactory;
    

    private Session getSession(){
    
        return this.sessionFactory.getCurrentSession();
       
    }
    
  
    @Override
    @Transactional
    public void save(Direccion direccion) {
        getSession().save(direccion);
    }

    @Override
    @Transactional
    public List<Direccion> findById(int id) {
        
          Query query = getSession().createQuery("from Direccion where idAd=:id", Direccion.class);
          query.setParameter("id", id);
          
          
          
          return query.getResultList() ;
    }
    
}
