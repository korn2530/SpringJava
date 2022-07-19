package pe.javita;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import pe.javita.dao.AdminDao;
import pe.javita.pojo.Admin;



public class Principal {

	public static void main(String[] args) {
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = context.getBean("adminDao",AdminDao.class);
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		/*
		Admin admin  = new Admin();
		admin.setCargo("gerente");
		admin.setNombre("Pedro");
		admin.setFechaCreacion(ts);
		*/
		
		try {
			
			List<Admin> admins = new ArrayList<Admin>();
			
			admins.add(new Admin(20,"Pedro","Jefe de proyecto",ts));
			admins.add(new Admin(30,"Rodrigo","Jefe de proyecto",ts));
			
			//para probar los valores enteros
			int[] val = adminDao.saveAll(admins);
			
		for (int i : val) {
			
			System.out.println("Actualizado correctamente: "+ i);
		}
			
			//adminDao.save(admin);
			/*
			Admin admin = adminDao.findById(1);
			System.out.print(admin);
			
			admin.setCargo("subgerente");
			admin.setNombre("Leon");
			
			if(adminDao.update(admin)) {
				
				System.out.print("Actualizado correctamente: "+ admin);
				
			}
			
			if(adminDao.delete(admin.getIdAd())) {
				
				System.out.print("Admin: "+ admin.getNombre()+ "eliminado correctamente");
				
			}
			
			*/
			
			/*List<Admin> admins = adminDao.findAll();
			
			for (Admin admin2 : admins) {
				
				System.out.println(admin2);
			}*/
			/*
			System.out.println(adminDao.findById(3));
			System.out.println(adminDao.findById(17));
			
			System.out.println(adminDao.findByNombre("r").toString());
			*/
			
			
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}catch (DataAccessException ex) {
		ex.printStackTrace();
		}
		

		
		  
		context.close();


	}

}
