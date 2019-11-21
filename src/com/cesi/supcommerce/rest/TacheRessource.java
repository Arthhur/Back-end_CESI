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
import fr.cesi.commerce.dao.jpa.JpaTacheDao;
import fr.cesi.commerce.entity.Tache;

@Path("/taches") 
public class TacheRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tache> getAllTachesInJson() {
		JpaTacheDao tacheDao = (JpaTacheDao)DaoFactory.getTacheDao() ;
		return tacheDao.getAllTaches() ;
	}
	
	@GET 
	@Path("/tache/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache getTacheInJson(@PathParam("id") Long tacheId) {
		JpaTacheDao tacheDao = (JpaTacheDao)DaoFactory.getTacheDao() ;
		return tacheDao.findTacheById(tacheId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tache removeTache(@PathParam("id") Long tacheId) {
		JpaTacheDao tacheDao = (JpaTacheDao)DaoFactory.getTacheDao() ;
		Tache t = tacheDao.findTacheById(tacheId) ;
		tacheDao.removeTache(t);
		return t ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTache(Tache t) {
		JpaTacheDao tacheDao = (JpaTacheDao)DaoFactory.getTacheDao() ;
		tacheDao.addTache(t) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editTache(@PathParam("id") Long tacheId, Tache t) {
		JpaTacheDao tacheDao = (JpaTacheDao)DaoFactory.getTacheDao() ;
		tacheDao.editTache(t);
	}
	
}
