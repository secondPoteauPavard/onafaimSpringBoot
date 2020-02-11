package projetSopra.onafaim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.Etat;
import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.model.LigneCommandePK;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	List<Commande> findAllByEtat(Etat etat);
	
	//PAS SUR DU TOUT DE MA REQUETE
	@Query("from Commande c left join LigneCommande lc where id=:id and command_id=:id") //je veux recuperer uniquement les commandes ayant le même id_commande
	List<LigneCommande> findAllById(Long id);
	
}

