package fr.cesi.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projet")
public class Projet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id  ;
	private String libelle ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_reunion", referencedColumnName = "id")
	private Reunion reunion ;
	
	public Projet() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

}
