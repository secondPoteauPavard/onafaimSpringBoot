package projetSopra.onafaim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.model.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,LigneCommandePK> {

}
