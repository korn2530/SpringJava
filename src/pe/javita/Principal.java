package pe.javita;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.javita.dao.AdminDao;
import pe.javita.pojo.Admin;



public class Principal {

	public static void main(String[] args) {
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = context.getBean("adminDao",AdminDao.class);
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		
		
		Admin admin  = new Admin();
		admin.setCargo("gerente");
		admin.setNombre("juan");
		admin.setFechaCreacion(ts);
		
		if(adminDao.save(admin)) {
			
			System.out.print("Admin salvado correctamente");
			
		}else {
			
			System.out.print("Error al insertar");
			
		}
		

		
		  
		context.close();


	}

}
