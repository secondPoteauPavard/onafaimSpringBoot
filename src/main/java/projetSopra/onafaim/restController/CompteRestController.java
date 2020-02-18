package projetSopra.onafaim.restController;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CompteRestController {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/auth/inscription")
	public ResponseEntity<Compte> inscription(@RequestBody @Valid Compte compte, BindingResult br){
		if(br.hasErrors()) {
			System.out.println(compte.getId() + compte.getPassword() + compte.getRole());
			return new ResponseEntity<Compte>(HttpStatus.NOT_IMPLEMENTED);
		}	
		System.out.println(passwordEncoder.encode(compte.getPassword()));
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));    // pour encoder le mdp, deplacer dans le repository
		compteRepository.save(compte);
		return new ResponseEntity<Compte>(compte, HttpStatus.CREATED);
	}
	
	@PutMapping("/page/editCompte/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid Compte compte, BindingResult br){
		Optional<Compte> opt=compteRepository.findById(id);
		if(opt.isPresent()) {
			compteRepository.save(compte);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		Optional<Compte> opt=compteRepository.findById(id);
		if(opt.isPresent()) {
			compteRepository.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
