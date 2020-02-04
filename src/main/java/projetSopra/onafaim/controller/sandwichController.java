package projetSopra.onafaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.TypeProduit;
import repositories.ProduitRepository;

@Controller
@RequestMapping("/page")
public class sandwichController {

	@Autowired
	ProduitRepository produitRepository;

	@GetMapping("/listSandwich")
	public String listAdmin(Model model) {
		model.addAttribute("produit", produitRepository.findAllByType(TypeProduit.Sandwich));
		return "page/listSandwich";
	}	
	
	@GetMapping("/listSandwich/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		produitRepository.deleteById(id);
		return "redirect:/page/listSandwich";
	}

}
