package projetSopra.onafaim.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.Etat;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	List<Commande> findAllByEtat(Etat etat);
	
	//PAS SUR DU TOUT DE MA REQUETE
//	@Query("from Commande c where id=:id") //je veux recuperer uniquement les commandes ayant le même id_commande
//	List<Commande> findAllById(Long id);
	
	@Query("from Commande c left join fetch c.panier where c.id=:id")
	Optional<Commande> findByIdWithPanier(Long id);
	
	
}

