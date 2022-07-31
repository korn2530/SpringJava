package pe.javita.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.javita.pojo.Admin;

@Repository
public class adminDaoImpl implements adminDao {

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {

        return this.sessionFactory.getCurrentSession();

    }

    @Override
    @Transactional
    public void save(Admin admin) {

        getSession().save(admin);

    }

    @Override
    @Transactional
    public List<Admin> findAll() {
        
        //crear la consulta
       // TypedQuery<Admin> lista = getSession().createQuery("From Admin", Admin.class);
        
        Query query = getSession().createQuery("from Admin");
        
        //obtener la lista
        
       // List<Admin> listar = lista.getResultList();
        
       return query.getResultList();
    }

    @Override
    @Transactional
    public Admin findById(int id) {
        
        //Query query  = getSession().createNamedQuery("from admin where idAd=:id");
        
        Admin admin =  getSession().get(Admin.class, id);
      
        
        return admin;
        
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        
        getSession().saveOrUpdate(admin);
    }

    @Override
    @Transactional
    public void delete(int id) {
        
        Admin admin  = getSession().get(Admin.class, id);
        
        getSession().delete(admin);
    }

    @Override
    @Transactional
    public List<Admin> findByName(String nombre) {
        
        Query query = getSession().createQuery("from admin where nombre like '%:nombre%' ",Admin.class);
        
        return query.getResultList();
        
    }

}
