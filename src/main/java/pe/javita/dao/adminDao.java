package pe.javita.dao;

import java.util.List;
import pe.javita.pojo.Admin;

public interface adminDao {
	
	void save(Admin admin);
        List<Admin> findAll();
        Admin findById(int id);
        void update(Admin admin);
        void delete(int id);
        List<Admin> findByName(String nombre);

}
