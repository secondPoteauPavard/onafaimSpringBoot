package projetSopra.onafaim.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projetSopra.onafaim.model.Produit;
import projetSopra.onafaim.model.TailleProduit;
import projetSopra.onafaim.model.TypeProduit;
import projetSopra.onafaim.repositories.ProduitRepository;

@Controller
@RequestMapping("/page")
public class produitController {

	@Autowired
	ProduitRepository produitRepository;
	
	@PostMapping("/save")
	public String save(@ModelAttribute("produit")@Valid Produit produit, BindingResult br, Model model) {
		System.out.println("test" + produit);
		if(br.hasErrors()) {
			model.addAttribute("produit", produit);
			return "page/editProduit";
		} else {
			if(produit.getType()==TypeProduit.Sandwich) {
				produitRepository.save(produit);
				return "redirect:/page/listSandwich"; 
			}
			else if(produit.getType()==TypeProduit.Viennoiserie) {
				produitRepository.save(produit);
				return "redirect:/page/listViennoiserie"; 
			}
			else if(produit.getType()==TypeProduit.Boissons) {
				produitRepository.save(produit);
				return "redirect:/page/listBoisson";
			}
			else if(produit.getType()==TypeProduit.Gateau) {
				produitRepository.save(produit);
				return "redirect:/page/listGateau";
			}
			return "redirect:/accueil";
		}
	}
		
	private String goEdit(Produit p, Model model) {
		model.addAttribute("produit", p);
		model.addAttribute("type", TypeProduit.values());
		model.addAttribute("taille", TailleProduit.values());
		if(p.getType()==TypeProduit.Sandwich) {
			model.addAttribute("chemin", "/page/listSandwich");
		}
		else if(p.getType()==TypeProduit.Viennoiserie) {
			model.addAttribute("chemin", "/page/listViennoiserie");
		}
		else if(p.getType()==TypeProduit.Boissons) {
			model.addAttribute("chemin", "/page/listBoisson");
		}
		else if(p.getType()==TypeProduit.Gateau) {
			model.addAttribute("chemin", "/page/listGateau");
		}
		return "page/editProduit";
	}
	
	@GetMapping("/addProduit")
	public String addProduit(Model model) {
		return goEdit(new Produit(), model);
	}
	
	@GetMapping("/editProduit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Produit> opt= produitRepository.findById(id); //je r�cup�re la personne en base
		Produit p=null;
		if(opt.isPresent()) { //si elle existe je continue
			p=opt.get(); 
			return goEdit(p, model);
		} else {
			return "addProduit";
		}
		
	}
	 

}
