package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Collaborateur;

public interface CollaborateurDao {

	public Collaborateur addCollaborateur(Collaborateur c) ;
	public void editCollaborateur(Collaborateur c) ;
	public List<Collaborateur> getAllCollaborateurs() ;
	public Collaborateur findCollaborateurById(Long id) ;
	public void removeCollaborateur(Collaborateur c) ;
}
