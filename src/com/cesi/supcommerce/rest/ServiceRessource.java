package com.cesi.supcommerce.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaServiceDao;
import fr.cesi.commerce.entity.Service;
import fr.cesi.commerce.entity.Service;

@Path("/services") 
public class ServiceRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Service> getAllServicesInJson() {
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		return serviceDao.getAllServices() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Service getServiceInJson(@PathParam("id") Long serviceId) {
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		return serviceDao.findServiceById(serviceId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Service removeService(@PathParam("id") Long serviceId) {
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		Service s = serviceDao.findServiceById(serviceId) ;
		serviceDao.removeService(s);
		return s ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addService(Service s) {
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		serviceDao.addService(s) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editService(@PathParam("id") Long serviceId, Service s) {
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		serviceDao.editService(s);
	}
	
}
