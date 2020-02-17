package projetSopra.onafaim.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.jsonView.JsonViews;
import projetSopra.onafaim.repositories.CommandeRepository;
import projetSopra.onafaim.repositories.LigneCommandeRepository;

@RestController
@CrossOrigin(origins = {"*"})
public class LigneDeCommandeRestController {

	
	
	public LigneDeCommandeRestController() {
		System.out.println("Ligne de commande rest controller");
	}

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private LigneCommandeRepository lcRepository;
	
	@GetMapping("/panier/{id}")
	@JsonView(JsonViews.Panier.class)
	public ResponseEntity<Commande> panier(@PathVariable ("id") Long id){
		Optional<Commande> opt=commandeRepository.findByIdWithPanier(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Commande>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/panier/{id}")
//	public ResponseEntity<List<LigneCommande>> list(@PathVariable ("id") LigneCommandePK id) {
//		return new ResponseEntity<List<LigneCommande>>(lcRepository.findAllById(id),HttpStatus.OK);
//	 }
}
