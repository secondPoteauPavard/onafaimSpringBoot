package projetSopra.onafaim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetSopra.onafaim.model.Devis;
import projetSopra.onafaim.model.Etat;

public interface DevisRepository extends JpaRepository<Devis,Long> {

	List<Devis> findAllByEtat(Etat etat);

	
	 
}
