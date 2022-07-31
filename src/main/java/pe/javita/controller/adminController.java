package pe.javita.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.javita.pojo.Admin;
import pe.javita.service.adminService;

@Controller
public class adminController {
	
	@RequestMapping("/")
	public String showIndex() {
		
		return "index";
	}
	
	@RequestMapping("/admin")
	public String showAdminCrud(Model model) {
		
               //listar al iniciar adminCrud
               
               List<Admin> listar = adService.findAll();
               
               model.addAttribute("listar",listar);
            
               //al comenzar el controlador por admin obtiene el objeto admin vacio
               Admin admin = new Admin();
               
               model.addAttribute("admin",admin);
               
                
		return "adminCRUD";	
	}
        
        @PostMapping("/saveOrUpdate")
        public String saveAdmin(@ModelAttribute("admin") Admin admin){
            
          adService.saveOrUpdate(admin);
            
          return "redirect:/admin";
        }
        
        @RequestMapping("/{idAd}")
        public String showIdAdmin(Model modelo,@PathVariable("idAd") int idAd){
                    
            Admin admin = adService.findById(idAd);
            
            System.out.println(admin);
            
            modelo.addAttribute("admin",admin);
            
            return "/adminCRUD";
        }
        
            @RequestMapping("delete/{idAd}")
        public String deleteByIdAdmin(@PathVariable("idAd") int idAd){
                    
            adService.delete(idAd);

            return "redirect:/admin";
        }
        
        

       @Autowired
       private adminService adService;
        
}
