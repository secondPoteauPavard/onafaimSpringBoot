package projetSopra.onafaim.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Commande;
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
}
