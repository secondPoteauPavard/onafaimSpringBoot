package projetSopra.onafaim.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.model.jsonView.JsonViews;
import projetSopra.onafaim.repositories.CommandeRepository;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CommandeRestController {

	@Autowired
	CommandeRepository commandeRepository; 
	
	@GetMapping("/listCommande")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Commande>> listCommande(){
		return new ResponseEntity<List<Commande>>(commandeRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/listCommande/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Commande> getCommandeById(@PathVariable ("id") Long id) {
		Optional<Commande> opt=commandeRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Commande>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/commande/save")
	public ResponseEntity<Void> update(@RequestBody @Valid Commande commande){
		commandeRepository.save(commande);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}







