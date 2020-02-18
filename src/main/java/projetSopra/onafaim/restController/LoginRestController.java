package projetSopra.onafaim.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@RestController
@CrossOrigin("*")
public class LoginRestController {
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/rest/login")
	public ResponseEntity<Compte> login(@RequestBody LoginDTO login) {

		System.out.println(login.getEmail());
		System.out.println(login.getPassword());

		Optional<Compte> opt = compteRepository.findByEmail(login.getEmail());
		if (opt.isPresent()) {
			Compte compte = opt.get();

			if (passwordEncoder.matches(login.getPassword(), compte.getPassword())) {
				System.out.println(opt + " accepted");
				return new ResponseEntity<Compte>(opt.get(), HttpStatus.ACCEPTED);
			}
		}
		System.out.println(opt + " not_found");
		return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
	}



	public static class LoginDTO {
		private String email;
		private String password;

		public LoginDTO() {
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

}