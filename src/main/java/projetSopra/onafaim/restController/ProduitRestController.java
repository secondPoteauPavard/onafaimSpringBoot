package projetSopra.onafaim.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Produit;
import projetSopra.onafaim.model.TypeProduit;
import projetSopra.onafaim.model.jsonView.JsonViews.Common;
import projetSopra.onafaim.repositories.ProduitRepository;

@RestController
@RequestMapping("/rest/page")
public class ProduitRestController {

	
	@Autowired
	ProduitRepository produitRepository;
	
	
	// ------------------------------------- VIENNOISERIE- ------------------------------
	@GetMapping("/viennoiserie")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listViennoiserie() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Viennoiserie),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/viennoiserie/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isPresent()) {
			produitRepository.deleteById(id);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	// idée : mettre tout les delete avec un meme debut de chemin (rest/page/delete/viennoiserie)
	// pour pouvoir gérer facilement le authorisations (= tout ce qui est dans delete)
	
	
	
	//------------------------------  GATEAU ------------------------------------------
	
	
	
	
	
}















