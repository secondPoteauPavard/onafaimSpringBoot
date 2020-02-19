package projetSopra.onafaim.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Email;

@Entity
@Table(name="compte")
@SequenceGenerator(name="seqCompte", sequenceName = "seq_Compte", initialValue = 100, allocationSize = 1)
public class Compte {

	@Id
	@GeneratedValue(generator = "seqCompte", strategy = GenerationType.SEQUENCE)
	private Long id; 
	@Column(name="nom", nullable=true)
	private String nom;
	@Column(name="prenom", nullable=true)
	private String prenom; 
	@Column(name="numero", length=10, nullable=true)
	private String numero;
	@Column(name="email", nullable=true)
	@Email
	private String email; 
	@Column(name="password", nullable=true)
	private String password; 
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private RoleCompte role=RoleCompte.ROLE_CLIENT; 
	@Column(name="enable")
	private boolean enable=true;
	@Column(name="date_de_creation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation= new Date();
	@Version
	private int version;
	@OneToMany(mappedBy="compte")  
	private Set<Commande> commandes;
	@OneToMany(mappedBy="compte")
	private Set<Devis> deviss;
	
	
	
	
	public Compte() {
	}

	public Compte(String nom, String prenom, String numero, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idCompte) {
		this.id = idCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleCompte getRole() {
		return role;
	}

	public void setRole(RoleCompte role) {
		this.role = role;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getVersion() {
		return version;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<Devis> getDeviss() {
		return deviss;
	}

	public void setDeviss(Set<Devis> deviss) {
		this.deviss = deviss;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}