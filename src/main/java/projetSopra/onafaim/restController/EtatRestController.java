package projetSopra.onafaim.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.Etat;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class EtatRestController {
	
	@GetMapping("/etatEnum")
	@JsonView
	public Etat[] getEtat() {
		return Etat.values();
	}
	

}
