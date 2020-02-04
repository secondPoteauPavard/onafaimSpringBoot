package projetSopra.onafaim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetSopra.onafaim.model.Commande;
import projetSopra.onafaim.model.Etat;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	List<Commande> findAllByEtat(Etat etat);
	
}

