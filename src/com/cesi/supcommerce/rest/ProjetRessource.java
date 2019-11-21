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
import fr.cesi.commerce.dao.jpa.JpaProjetDao;
import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Service;

@Path("/projets") 
public class ProjetRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Projet> getAllProjetsInJson() {
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		return projetDao.getAllProjets() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Projet getProjetInJson(@PathParam("id") Long projetId) {
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		return projetDao.findProjetById(projetId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Projet removeProjet(@PathParam("id") Long projetId) {
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		Projet p = projetDao.findProjetById(projetId) ;
		projetDao.removeProjet(p);
		return p ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProjet(Projet p) {
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		projetDao.addProjet(p) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editProjet(@PathParam("id") Long categorytId, Projet p) {
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		projetDao.editProjet(p);
	}
	
}
