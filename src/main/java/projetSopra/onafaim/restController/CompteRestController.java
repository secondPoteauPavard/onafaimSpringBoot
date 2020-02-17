package projetSopra.onafaim.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@RestController
public class CompteRestController {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/auth/inscription")
	public ResponseEntity<Compte> inscription(@RequestBody @Valid Compte compte, BindingResult br){
		if(br.hasErrors()) {
			compte.setPassword(passwordEncoder.encode(compte.getPassword()));    // pour encoder le mdp
			compteRepository.save(compte);
			return new ResponseEntity<Compte>(compte, HttpStatus.CREATED);
		}
		return new ResponseEntity<Compte>(HttpStatus.NOT_IMPLEMENTED);
	}
	
//	@PostMapping("/page/editCompte/{id}")
//	public ResponseEntity<Compte> update(@PathVariable("id") Long id, @RequestBody @Valid Compte compte, BindingResult br){
//		
//	}
	
	
	
	
}
