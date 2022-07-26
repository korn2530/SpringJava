package pe.javita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.javita.pojo.Admin;
import pe.javita.service.AdminService;

@Controller
public class adminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin")
	public String showAdmin(Model model ,@ModelAttribute("resp") String resp) {

		List<Admin> admins = adminService.findAll();
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
	   model.addAttribute("resp",resp);
	   model.addAttribute("admins", admins);
	   
		System.out.println(admin);

		return "admin";
	}

	@PostMapping("/adminSave")
	public String handleAdmin(@ModelAttribute("admin") Admin eladmin,
			Model model/* ,@RequestParam("estado") String estado */) {

		if (adminService.saveOrUpdate(eladmin)) {
			
			System.out.println("Se guardo con exito");
			
			model.addAttribute("resp", "Se guardo con exito");

		} else {
			model.addAttribute("resp", "Error al guardar");

		}

		// model.addAttribute("eladmin", eladmin);

		/*
		 * System.out.println(eladmin); System.out.println(estado);
		 * model.addAttribute("prueba","hola");
		 */
		return "redirect:/admin";
	}
	
	///admin/${admins.idAd}/update
	
	@GetMapping("/{idAd}")
	public String showUpdate(Model model, @PathVariable("idAd") int id) {
		
		 Admin admin  =  adminService.findById(id);
		 model.addAttribute("admin", admin);
		 System.out.println(admin);
		 
		return "admin";
	}
	
	@GetMapping("/{idAd}/delete")
	public String showDelete(Model model, @PathVariable("idAd") int id) {
		
		
	if (adminService.delete(id)) {
			
			System.out.println("Se borro con exito");
			
			model.addAttribute("resp", "Se borro con exito");

		} else {
			model.addAttribute("resp", "Error al borrar");

		}
		
		 
		return "redirect:/admin";
	}

}
