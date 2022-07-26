package pe.javita;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("resultado")
public class IndexController {
	
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		
		model.addAttribute("resultado","resultado desde session");
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout() {
		
		return "about";
	}
	

}
