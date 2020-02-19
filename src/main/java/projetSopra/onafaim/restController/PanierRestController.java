package projetSopra.onafaim.restController;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.model.Produit;
import projetSopra.onafaim.model.jsonView.JsonViews;
import projetSopra.onafaim.repositories.CommandeRepository;
import projetSopra.onafaim.repositories.LigneCommandeRepository;

@RestController
@CrossOrigin(origins = {"*"})
public class PanierRestController {


	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private LigneCommandeRepository lcRepository;
	
//	@PostMapping("/commande/save")
//	public ResponseEntity<Void> savePanier(@RequestBody Commande commande) {
//		commandeRepository.save(commande); 
//		for (LigneCommande lc : commande.getPanier()) {
//			lcRepository.save(lc);
//		}
//		return new ResponseEntity<> (HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/ligneCommande/save")
//	public ResponseEntity<Void> saveLigneCommande(@RequestBody LigneCommande ligneCommande) {
//		lcRepository.save(ligneCommande); 
//		return new ResponseEntity<> (HttpStatus.CREATED);
//	}
//	
//	
//	@GetMapping("/commande/{id}")
//	@JsonView(JsonViews.CommandeWithCompteAndPanier.class)
//	public ResponseEntity<Commande> panier(@PathVariable ("id") Long id){
//		Optional<Commande> opt=commandeRepository.findByIdWithPanier(id);
//		if(opt.isPresent()) {
//			return new ResponseEntity<Commande>(opt.get(), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
}



