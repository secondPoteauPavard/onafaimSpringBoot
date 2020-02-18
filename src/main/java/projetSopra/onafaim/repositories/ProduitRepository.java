package projetSopra.onafaim.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetSopra.onafaim.model.Produit;
import projetSopra.onafaim.model.TailleProduit;
import projetSopra.onafaim.model.TypeProduit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
	
	List<Produit> findAllByTaille(TailleProduit taille); 
	List<Produit> findAllByType(TypeProduit type); 
	
}
