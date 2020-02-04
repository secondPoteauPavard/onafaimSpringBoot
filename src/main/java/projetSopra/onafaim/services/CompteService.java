package projetSopra.onafaim.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projetSopra.onafaim.model.Compte;
import projetSopra.onafaim.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;
	
	public boolean save(Compte c) { 
		Compte compteBase=null;
		
		if(c.getId()!=null) {
			//update d'une compte
			Optional<Compte> opt= compteRepository.findById(c.getId());
			if(opt.isPresent()) {
				compteBase=opt.get();
				compteBase.setId((c.getId()!=null)?c.getId():compteBase.getId());
				compteBase.setNom((c.getNom()!=null)?c.getNom():compteBase.getNom());
				compteBase.setPrenom((c.getPrenom()!=null)?c.getPrenom():compteBase.getPrenom());
				compteBase.setNumero((c.getNumero()!=null)?c.getNumero():compteBase.getNumero());
				compteBase.setEmail((c.getEmail()!=null)?c.getEmail():compteBase.getEmail());
				compteBase.setPassword((c.getPassword()!=null)?c.getPassword():compteBase.getPassword());
				compteBase.setEnable((c.isEnable()==true)?c.isEnable():compteBase.isEnable()==false);
				compteBase.setDateCreation((c.getDateCreation()!=null)?c.getDateCreation():compteBase.getDateCreation());
				compteBase.setVersion((c.getVersion()!=0)?c.getVersion():compteBase.getVersion());
				
				compteRepository.save(compteBase);
				return true;
			}
		}else {
			//creation d'une compte
			boolean erreur=false;
			if(c.getId()==null) {
				erreur=true;
			}
			if(c.getNom()==null) {
				erreur=true;
			}
			if(c.getPrenom()==null) {
				erreur=true;
			}
			if(c.getNumero()==null) {
				erreur=true;
			}
			if(c.getEmail()==null) {
				erreur=true;
			}
			if(c.getPassword()==null) {
				erreur=true;
			}
			if(c.isEnable()==true) {
				erreur=true;
			}
			if(c.getDateCreation()==null) {
				erreur=true;
			}
			if(c.getVersion()==0) {
				erreur=true;
			}
			if(!erreur) {
				compteRepository.save(c);
				return true;
			}
		}
		return false;
	}
	
}
