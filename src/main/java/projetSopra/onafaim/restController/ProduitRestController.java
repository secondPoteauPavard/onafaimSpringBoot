package projetSopra.onafaim.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/rest/page")
@CrossOrigin(origins = {"*"})
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
	public ResponseEntity<Void> deleteViennoiserie(@PathVariable("id") Long id) {
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
	
	@GetMapping("/gateau")
	@JsonView(Common.class)
	public ResponseEntity<List<Produit>> listGateau() {
		return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Gateau),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/gateau/{id}")
	public ResponseEntity<Void> deleteGateau(@PathVariable("id") Long id) {
		Optional<Produit> opt = produitRepository.findById(id);
		if (opt.isPresent()) {
			produitRepository.deleteById(id);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	
	//------------------------------  BOISSON ------------------------------------------
	
		@GetMapping("/boisson")
		@JsonView(Common.class)
		public ResponseEntity<List<Produit>> listBoisson() {
			return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Boissons),HttpStatus.OK);
		}
		
		
		@DeleteMapping("/boisson/{id}")
		public ResponseEntity<Void> deleteBoisson(@PathVariable("id") Long id) {
			Optional<Produit> opt = produitRepository.findById(id);
			if (opt.isPresent()) {
				produitRepository.deleteById(id);
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
		
	//------------------------------  SANDWICH ------------------------------------------
		
		@GetMapping("/sandwich")
		@JsonView(Common.class)
		public ResponseEntity<List<Produit>> listSandwich() {
			return new ResponseEntity<List<Produit>> (produitRepository.findAllByType(TypeProduit.Sandwich),HttpStatus.OK);
		}
		
		
		@DeleteMapping("/sandwich/{id}")
		public ResponseEntity<Void> deleteSandwich(@PathVariable("id") Long id) {
			Optional<Produit> opt = produitRepository.findById(id);
			if (opt.isPresent()) {
				produitRepository.deleteById(id);
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
	
		
		
		
		
		@PostMapping({"","/"})
		public ResponseEntity<Void> addProduit(@RequestBody Produit produit, UriComponentsBuilder uCB) {
			Optional<Produit> opt= produitRepository.findById(produit.getId()); 
			if(opt.isPresent()) {
				return new ResponseEntity<> (HttpStatus.CONFLICT); 
			}
			produitRepository.save(produit); 
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(uCB.path("/rest/produit/{id}").buildAndExpand(produit.getId()).toUri()); 
			return new ResponseEntity<> (headers, HttpStatus.CREATED);
		}	
	
		
}















