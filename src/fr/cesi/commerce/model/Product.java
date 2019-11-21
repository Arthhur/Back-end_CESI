package fr.cesi.commerce.model;

public class Product {
	private String nom = "" ;
	private String contenu = "" ;
	private double prix = 0 ;
	private Long id  ;
	
	
	public Product(Long id, String nom, String contenu, double prix) {
		this.id = id ;
		this.nom = nom ;
		this.contenu = contenu ;
		this.prix = prix ;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}
}
