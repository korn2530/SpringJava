
package pe.javita.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.javita.pojo.Admin;
import pe.javita.pojo.Direccion;
import pe.javita.service.adminService;
import pe.javita.service.direccionService;

@Controller
@RequestMapping("/direccion")
@SessionAttributes("admin")
public class direccionController {
    
    @Autowired
    private direccionService diService;
    
    @Autowired
    private adminService adminService;
    
    @RequestMapping("/{idAd}")
    public String showDireccion(Model modelo,@PathVariable("idAd") int idAd,@ModelAttribute("resultado") String resultado){
        
        //mostrar lista de admin y direccion
        
        List<Direccion> direccion=diService.findAll(idAd);
        System.out.println("--------BD DIRECCION--------");
        System.out.println(direccion);
        modelo.addAttribute("dire",direccion);
        
        Admin admin  = adminService.findById(idAd);
        
        modelo.addAttribute("admin",admin);
        
         System.out.println(admin);
         
        modelo.addAttribute("direccion", new Direccion());
        
        //mostrar resultado de save 
        modelo.addAttribute("resultado", resultado);
    
       return "direccion";
    }
    
    @PostMapping("/save")
    public String saveDireccion(Model modelo,
            @ModelAttribute("direccion") Direccion direccion,
             @ModelAttribute("admin") Admin admin ){
        
        
        diService.save(admin,direccion);
        modelo.addAttribute("resultado", "Guardado con exito");
        
        
        return "redirect:/direccion/"+admin.getIdAd();
    
    }
    
    
}
