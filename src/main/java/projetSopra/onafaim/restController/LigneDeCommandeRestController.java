package projetSopra.onafaim.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.model.LigneCommandePK;
import projetSopra.onafaim.repositories.CommandeRepository;
import projetSopra.onafaim.repositories.LigneCommandeRepository;

@RestController
@CrossOrigin(origins = {"*"})
public class LigneDeCommandeRestController {

	@Autowired
	private CommandeRepository commandeRepository;
	
	@GetMapping("/panier")
	public ResponseEntity<List<LigneCommande>> list(Long id){
		return new ResponseEntity<List<LigneCommande>>(commandeRepository.findAllById(id),HttpStatus.OK);
	}
}
