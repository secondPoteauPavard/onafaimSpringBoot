package projetSopra.onafaim.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;
	
;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------------------------bonjour");
		//System.out.println(passwordEncoder.encode("toto"));
	}

}
