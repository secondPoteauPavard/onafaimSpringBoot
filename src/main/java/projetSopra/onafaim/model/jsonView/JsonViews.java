package projetSopra.onafaim.model.jsonView;

public class JsonViews {

	
	
	
	public static class Common {	
	}
	
	
	public static class CommandeWithPanier extends Common{}
	public static class CommandeWithCompteAndPanier extends CommandeWithPanier{}

	
	public static class ProduitCommande extends Common{
		
	}
	
	public static class idCommande extends CommandeWithPanier{
		
	}
	
	
	
}