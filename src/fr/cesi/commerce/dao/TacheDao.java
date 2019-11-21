package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Tache;

public interface TacheDao {

	public Tache addTache(Tache t) ;
	public void editTache(Tache t) ;
	public List<Tache> getAllTaches() ;
	public Tache findTacheById(Long id) ;
	public void removeTache(Tache t) ;
}
