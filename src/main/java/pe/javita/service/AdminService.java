package pe.javita.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.javita.dao.adminDao;
import pe.javita.pojo.Admin;

@Service
public class AdminService {
	
	@Autowired
	private adminDao adminDao;
	
	public boolean save(Admin admin) {
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		
		return adminDao.save(admin);
	}

	public List<Admin> findAll() {
	  

		return adminDao.findAll();
	}

	public Admin findById(int idAd) {
		
		
		return adminDao.findById(idAd);
	}

	public boolean saveOrUpdate(Admin admin) {
		
		System.out.println(admin);
		
		if(admin.getIdAd()==0) {
			//Insert
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			return adminDao.save(admin);
			
			
		}else {
			
			//update
			
			return adminDao.update(admin);
		}
		
		
	}

	public boolean delete(int id) {
	
		return adminDao.delete(id);
		
	}

	

}
