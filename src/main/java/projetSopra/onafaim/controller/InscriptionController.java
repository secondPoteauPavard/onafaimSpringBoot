package projetSopra.onafaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@Controller
//@RequestMapping("/inscription")
public class InscriptionController {
	
	@Autowired
	CompteRepository compteRepository; 
	
	
	@GetMapping("/inscription")
    public ModelAndView add() { 
        return new ModelAndView("inscription", "compte", new Compte());
    }
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute("compte") Compte compte) {
		compteRepository.save(compte); 
		return new ModelAndView("redirect:/accueil"); 
	}
	
	

	
}
