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

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.model.Etat;
import projetSopra.onafaim.model.RoleCompte;
import projetSopra.onafaim.model.TypeProduit;
import projetSopra.onafaim.repositories.CompteRepository;
import projetSopra.onafaim.repositories.DevisRepository;
import projetSopra.onafaim.repositories.ProduitRepository;


@Controller
@RequestMapping("/page")
public class ViennoiserieController { // Nom controller a changer

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	DevisRepository devisRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	
//------------------------------  VIENNOISERIE ------------------------------------------
	@GetMapping("/listViennoiserie")
	public String listAdmin(Model model) {
		model.addAttribute("produit", produitRepository.findAllByType(TypeProduit.Viennoiserie));
		return "page/listViennoiserie";
	}
	
	@GetMapping("/listViennoiserie/delete")
	public String delete(@RequestParam(name="id") Long id) {
		produitRepository.deleteById(id);
		return "redirect:/page/listViennoiserie";
	}
	
		
		
		
		//------------------------------  GATEAU ------------------------------------------
		@GetMapping("/listGateau")
		public String listGateau(Model model) {
			model.addAttribute("produit", produitRepository.findAllByType(TypeProduit.Gateau));
			return "page/listGateau";
		}
		
		@GetMapping("/listGateau/delete")
		public String deleteGateau(@RequestParam(name="id") Long id) {
			produitRepository.deleteById(id);
			return "redirect:/page/listGateau";
		}
		
		
		
		//------------------------------  BOISSON ------------------------------------------
		@GetMapping("/listBoisson")
		public String listBoisson(Model model) {
			model.addAttribute("produit", produitRepository.findAllByType(TypeProduit.Boisson));
			return "page/listBoisson";
		}
		
		@GetMapping("/listBoisson/delete")
		public String deleteBoisson(@RequestParam(name="id") Long id) {
			produitRepository.deleteById(id);
			return "redirect:/page/listBoisson";
		}
	
		
		
		//------------------------------  DEVIS ------------------------------------------
		@GetMapping("/listDevis")
		public String listDevis(Model model) {
			model.addAttribute("devis", devisRepository.findAll());
			return "page/listDevis";
		}
		
		@GetMapping("/listDevis/delete")
		public String deleteDevis(@RequestParam(name="id") Long id) {
			devisRepository.deleteById(id);
			return "redirect:/page/listDevis";
		}
	
	
		
		
		//------------------------------  CLIENT ------------------------------------------
		@GetMapping("/listClient")
		public String listClient(Model model) {
			model.addAttribute("compte", compteRepository.findAllByRole(RoleCompte.ROLE_CLIENT));
			return "page/listClient";
		}
		
		@GetMapping("/listClient/delete")
		public String deleteClient(@RequestParam(name="id") Long id) {
			compteRepository.deleteById(id);
			return "redirect:/page/listClient";
		}
		
		@GetMapping("/editCompte")
		public String edit(@RequestParam(name="id") Long id, Model model) {
			Optional<Compte> opt= compteRepository.findById(id); //je r�cup�re la personne en base
			Compte c=null;
			if(opt.isPresent()) { //si elle existe je continue
				c=opt.get(); 
				return goEdit(c, model);
			} else {
				return "addCompte";
			}		
		}
		
		private String goEdit(Compte c, Model model) {
			model.addAttribute("compte", c);
			model.addAttribute("type", RoleCompte.values());
			model.addAttribute("etat", Etat.values()); // on n'affiche pas les commandes et devis associ�s ?
			return "page/editCompte";
		}
		
		@GetMapping("/addCompte")
		public String addCompte(Model model) {
			return goEdit(new Compte(), model);
		}
		
		@PostMapping("/saveCompte")
		public String save(@ModelAttribute("compte") @Valid Compte compte, BindingResult br, Model model) {
			System.out.println("--------------------------------save compte");
			if(br.hasErrors()) {
				System.out.println("--------------------------------has errors");
				return "page/editCompte";
			} else {
				compteRepository.save(compte);
				return "redirect:/accueil"; //rediriger vers accueil admin
			}
		}
		
	
	
	
	
	

	
}
