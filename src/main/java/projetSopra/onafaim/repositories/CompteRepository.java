package projetSopra.onafaim.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.model.Etat;
import projetSopra.onafaim.model.RoleCompte;


public interface CompteRepository extends JpaRepository<Compte, Long> {

	//@Query("from Compte c where email=:email and mdp=:mdp")
	Optional<Compte> findByEmailAndPassword(String email,String password);
	
	Optional<Compte> findByEmail(String email);
	
	//@Query("from Compte c where type=:type")	
	List<Compte> findAllByType(RoleCompte type);
	
	//@Query("from Compte c where compteEtat=:etat")
	List<Compte> findAllByCompteEtat(Etat etat);
	
}

