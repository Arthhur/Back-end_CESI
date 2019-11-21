package fr.cesi.commerce.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="projets")
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	
	private String titre = "" ;
	
	/* @OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(joinColumns={@JoinColumn(name="category_ID", referencedColumnName="id")}
	    , inverseJoinColumns={@JoinColumn(name="product_ID", referencedColumnName="id")})
    private Collection<Product> products ;*/
	
	private String description = "" ;
	
	private String deadline ;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service", referencedColumnName = "id")
	private Service service ;
	 
	public Projet() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	
	

}
