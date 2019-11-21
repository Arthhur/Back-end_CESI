package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Projet;

public interface ProjetDao {

	public Projet addProjet(Projet p) ;
	public void editProjet(Projet p) ;
	public List<Projet> getAllProjets() ;
	public Projet findProjetById(Long id) ;
	public void removeProjet(Projet p) ;
}
