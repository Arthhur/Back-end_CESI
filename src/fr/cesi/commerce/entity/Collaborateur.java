package fr.cesi.commerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collaborateur")
public class Collaborateur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id  ;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employe_id", referencedColumnName = "id")
	private Projet projet ;
	
	private String titre = "" ;
	private String description = "" ;
	

	public Collaborateur() {	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Projet getProjet() {
		return projet;
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
}
