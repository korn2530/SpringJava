package pe.javita.dao;

import pe.javita.pojo.Admin;
import java.util.*;

public interface AdminDao {
	
	boolean save(Admin admin);
	List<Admin> findAll();
	Admin findById(int id);
	List<Admin> findByNombre(String nombre);
	boolean update(Admin admin);
	boolean delete(int idAd);
	
	//batch
	
	int [] saveAll(List<Admin> admins );

}
