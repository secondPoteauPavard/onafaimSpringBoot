package projetSopra.onafaim.restController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import projetSopra.onafaim.model.TypeProduit;
import projetSopra.onafaim.model.jsonView.JsonViews.Common;

@RestController
@RequestMapping("/rest/page/produit/findtype")
@CrossOrigin("*")
public class TypeProduitRestController {

	@GetMapping({"","/"})
	@JsonView(Common.class)
	public TypeProduit[] getType(){
		return TypeProduit.values();
	}	
	
}
