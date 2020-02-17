package projetSopra.onafaim.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CompteRepository compteRepository;
;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("-------------------------------------bonjour");
		System.out.println(passwordEncoder.encode("toto"));
		
//		Optional<Compte> opt = compteRepository.findByEmail("toto");
//		System.out.println("1111111111111111111111111" + opt.get());
	}

}
