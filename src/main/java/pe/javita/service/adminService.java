package pe.javita.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.javita.dao.adminDao;
import pe.javita.pojo.Admin;

@Service
public class adminService {
	
	@Autowired
	private adminDao adminDao;
	
	public void save(Admin admin) {
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		adminDao.save(admin);
	}
        
        public List<Admin> findAll(){
        
             return adminDao.findAll();
                    
        }
        
       public Admin findById(int id){
       
            return adminDao.findById(id);
       }
       
       public void update(Admin admin){
                   
            adminDao.update(admin);
       }

       public void delete(int id){
       
             adminDao.delete(id);
       }

    public void saveOrUpdate(Admin admin) {
        
        if(admin.getIdAd()==0){
            admin.setFechaCreacion(new Timestamp(new Date().getTime()));
            adminDao.save(admin);
        }else{
        
           adminDao.update(admin);
        }
        
    }
}
