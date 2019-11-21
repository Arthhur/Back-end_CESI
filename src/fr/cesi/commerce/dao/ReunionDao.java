package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Reunion;

public interface ReunionDao {

	public Reunion addReunion(Reunion r) ;
	public void editReunion(Reunion r) ;
	public List<Reunion> getAllReunions() ;
	public Reunion findReunionById(Long id) ;
	public void removeReunion(Reunion r) ;
}
