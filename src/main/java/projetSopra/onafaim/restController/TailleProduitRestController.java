package projetSopra.onafaim.restController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import projetSopra.onafaim.model.TailleProduit;
import projetSopra.onafaim.model.jsonView.JsonViews.Common;


@RestController
@RequestMapping("/rest/page/produit/findsize")
@CrossOrigin("*")
public class TailleProduitRestController {

	@GetMapping({"","/"})
	@JsonView(Common.class)
	public TailleProduit[] getTaille(){
		return TailleProduit.values();
	}
}
