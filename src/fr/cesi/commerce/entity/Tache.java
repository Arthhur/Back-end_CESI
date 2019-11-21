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
@Table(name="taches")
public class Tache {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id  ;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_projet", referencedColumnName = "id")
	private Projet projet ;
	
	

	public Tache() {	
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
	

	
}
