package projetSopra.onafaim.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetSopra.onafaim.model.LigneCommande;
import projetSopra.onafaim.repositories.LigneCommandeRepository;

@Service
public class LigneCommandeService {
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	public boolean save(LigneCommande lc) {
		LigneCommande lcBase=null;
		
		if (lc.getId()==null) {
			//update
			Optional<LigneCommande> opt= ligneCommandeRepository.findById(lc.getId());
			if(opt.isPresent()) {
				lcBase=opt.get();
				lcBase.setId((lc.getId()!=null)?lc.getId():lcBase.getId());
				lcBase.setQte((lc.getQte()!=0)?lc.getQte():lcBase.getQte());
				lcBase.setVersion((lc.getVersion()!=0)?lc.getVersion():lcBase.getVersion());
				ligneCommandeRepository.save(lcBase);
				return true;
			}
		}
		else {
			//creation 
			boolean erreur=false;
			if(lc.getId()==null) {
				erreur=true;
			}
			if(lc.getQte()==0) {
				erreur=true;
			}
			if(lc.getVersion()==0) {
				erreur=true;
			}
			if(!erreur) {
				ligneCommandeRepository.save(lc); 
				return true; 
			}
		}
		return false;
	}

}
