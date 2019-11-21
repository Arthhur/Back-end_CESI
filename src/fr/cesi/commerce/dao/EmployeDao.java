package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Employe;
import fr.cesi.commerce.entity.Projet;

public interface EmployeDao {

	public Employe addEmploye(Employe e) ;
	public void editEmploye(Employe e) ;
	public List<Employe> getAllEmployes() ;
	public Employe findEmployeById(Long id) ;
	public void removeEmploye(Employe e) ;
	public Employe connexionEmp(String name, String pass) ;

}
