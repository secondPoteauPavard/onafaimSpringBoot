package projetSopra.onafaim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping("/accueil")
	public String index() {
		return "accueil";
	}
}
