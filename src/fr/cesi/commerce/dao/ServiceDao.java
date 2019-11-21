package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Service;
import fr.cesi.commerce.entity.Service;

public interface ServiceDao {

	public Service addService(Service s) ;
	public void editService(Service s) ;
	public List<Service> getAllServices() ;
	public Service findServiceById(Long id) ;
	public void removeService(Service s) ;
}
