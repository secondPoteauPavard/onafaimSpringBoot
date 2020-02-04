package projetSopra.onafaim.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@RestController
@RequestMapping("/rest/compte")
public class CompteRestController {

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/inscription")
	public ResponseEntity<Compte> inscription(@RequestBody @Valid Compte compte, BindingResult br){
		if(br.hasErrors()) {
			compte.setPassword(passwordEncoder.encode(compte.getPassword()));
			compteRepository.save(compte);
			return new ResponseEntity<Compte>(compte, HttpStatus.CREATED);
		}
		return new ResponseEntity<Compte>(HttpStatus.NOT_IMPLEMENTED);
	}
	
}
