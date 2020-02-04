package projetSopra.onafaim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.model.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,LigneCommandePK> {

}
