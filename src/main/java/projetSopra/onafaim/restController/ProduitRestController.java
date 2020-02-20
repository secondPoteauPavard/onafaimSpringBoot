package projetSopra.onafaim.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Produit;
import projetSopra.onafaim.model.TypeProduit;
import projetSopra.onafaim.model.jsonView.JsonViews.Common;
import projetSopra.onafaim.repositories.ProduitRepository;

@RestController
@RequestMapping("/rest/page/produit")
@CrossOrigin("*")
public class ProduitRestController {

	
	@Autowired
	ProduitRepository produitRepository;
	
	@GetMapping({"","/"})
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> list(){
		return new ResponseEntity<List<Produit>> (produitRepository.findAll(), HttpStatus.OK);
	}
	
// ------------------------------------- VIENNOISERIE- ------------------------------
	@GetMapping("/viennoiserie")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listViennoiserie() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Viennoiserie),HttpStatus.OK);
	}
	
	// idée : mettre tout les delete avec un meme debut de chemin (rest/page/delete/viennoiserie)
	// pour pouvoir gérer facilement le authorisations (= tout ce qui est dans delete)
	
	
	
//------------------------------  GATEAU ------------------------------------------
	
	@GetMapping("/gateau")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listGateau() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Gateau),HttpStatus.OK);
	}
	
	
//------------------------------  BOISSON ------------------------------------------
	
	@GetMapping("/boisson")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listBoisson() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Boisson),HttpStatus.OK);
	}
		
		
//------------------------------  SANDWICH ------------------------------------------
		
	@GetMapping("/sandwich")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listSandwich() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Sandwich),HttpStatus.OK);
	}
	
	
//-------------------------------------------------------------------------------------------------------------------
	

	@PutMapping("/editProduit/{id}")
	public ResponseEntity<Void> updateProduit(@PathVariable("id") Long id, @RequestBody Produit p){
		Optional<Produit> opt= produitRepository.findById(id); 
		if(opt.isPresent()) {
			produitRepository.save(p);
			return new ResponseEntity<> (HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping({"","/"})
	public ResponseEntity<Produit> saveProduit(@RequestBody Produit p, BindingResult br) {
		if(br.hasErrors()) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		produitRepository.save(p); 
		return new ResponseEntity<> (HttpStatus.CREATED);
	}	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isPresent()) {
			produitRepository.deleteById(id);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/{id}")
	@JsonView(Common.class)
	public ResponseEntity<Produit> findById(@PathVariable("id") Long id) {
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Produit> (opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	

		
}
