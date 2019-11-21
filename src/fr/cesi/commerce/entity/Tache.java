package fr.cesi.commerce.entity;

import java.util.Date;

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
@Table(name="tache")
public class Tache {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id  ;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reunion", referencedColumnName = "id")
	private Reunion reunion ;
	
	private String libelle ;
	private Date echeance ;
	

	public Tache() {	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Reunion getReunion() {
		return reunion;
	}


	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}


	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	
}
