package fr.cesi.commerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id  ;
	private String date ;
	private String lieu ;
	private String objectif ;
	private String compteRendu ;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_createur", referencedColumnName = "id")
	private Collaborateur createur ;
	@ManyToMany
	@JoinTable(
			  name = "participer", 
			  joinColumns = @JoinColumn(name = "reunion_id"), 
			  inverseJoinColumns = @JoinColumn(name = "collaborateur_id"))
	private List<Collaborateur> participant ;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_projet", referencedColumnName = "id")
	private Projet projet ;

	public Reunion() {	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public String getObjectif() {
		return objectif;
	}


	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}


	public String getCompteRendu() {
		return compteRendu;
	}


	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}


	public List<Collaborateur> getParticipant() {
		return participant;
	}


	public void setParticipant(List<Collaborateur> participant) {
		this.participant = participant;
	}


	public Collaborateur getCreateur() {
		return createur;
	}


	public void setCreateur(Collaborateur createur) {
		this.createur = createur;
	}


	public Projet getProjet() {
		return projet;
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	
	
}
