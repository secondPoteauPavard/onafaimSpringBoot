package projetSopra.onafaim.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import projetSopra.onafaim.model.jsonView.JsonViews;


@Entity
@Table(name="commande")
@SequenceGenerator(name="seqCommande",sequenceName="seq_commande",initialValue=100,allocationSize=1)
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCommande")
	@JsonView(JsonViews.Common.class)
	private Long id; 
	@Column(name="eval",length=255)
	@JsonView(JsonViews.Common.class)
	private String evaluation; 
	@Enumerated(EnumType.STRING)
	@Column(name="etat",length=1)
	@JsonView(JsonViews.Common.class)
	private Etat etat=Etat.W; // "en_attente" par d�faut
	@Temporal(TemporalType.DATE)
	@Column(name="dateCommande")
	@JsonView(JsonViews.Common.class)
	private Date date= new Date();
	@ManyToOne
	@JoinColumn(name="compte_id", foreignKey = @ForeignKey(name="commande_compte_fk"))
	@JsonView(JsonViews.CommandeWithCompteAndPanier.class)
	private Compte compte;
	@OneToMany (mappedBy= "id.commande") 
	@JsonView(JsonViews.CommandeWithPanier.class)
	private Set<LigneCommande> panier;
	@Version
	@JsonView(JsonViews.Common.class)
	private int version;

	

	public Commande() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(String eval) {
		this.evaluation = eval;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public Set<LigneCommande> getPanier() {
		return panier;
	}


	public void setPanier(Set<LigneCommande> panier) {
		this.panier = panier;
	}


	public int getVersion() {
		return version;
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
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

	
	
	

}