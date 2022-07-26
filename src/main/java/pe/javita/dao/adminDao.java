package pe.javita.dao;

import java.util.*;

import pe.javita.pojo.Admin;

public interface adminDao {
	
	boolean save(Admin admin);
	List<Admin> findAll();
	Admin findById(int idAd);
	boolean delete(int id);
	boolean update(Admin admin);
	
	

}
