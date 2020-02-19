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
	
	@PostMapping("/panier/save")
	public ResponseEntity<Void> savePanier(@RequestBody Commande commande, @RequestBody Set<LigneCommande> ligneCommandes) {
		Optional<Commande> opt= commandeRepository.findById(commande.getId()); // RESTE A FAIRE : vérifier les conflits pour ligneCommandes
		if(opt.isPresent()) {
			return new ResponseEntity<> (HttpStatus.CONFLICT); 
		}
		commandeRepository.save(commande); 
		for (LigneCommande lc : ligneCommandes) { 
			lcRepository.save(lc);
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<> (headers, HttpStatus.CREATED);
	}
	
}



