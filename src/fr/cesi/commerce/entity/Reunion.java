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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id  ;
	private Date date ;
	private String lieu ;
	private String objectif ;
	private String compteRendu ;
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "projet_id", referencedColumnName = "id")
	private Projet projet ;

	public Reunion() {	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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


	public Projet getProjet() {
		return projet;
	}


	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	
	
}
