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
import fr.cesi.commerce.dao.jpa.JpaCollaborateurDao;
import fr.cesi.commerce.entity.Collaborateur;

@Path("/collaborateurs") 
public class CollaborateurRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> getAllCollaborateursInJson() {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		return colDao.getAllCollaborateurs() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur getCollaborateurInJson(@PathParam("id") Long comId) {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		return colDao.findCollaborateurById(comId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur removeCollaborateur(@PathParam("id") Long comId) {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		Collaborateur c = colDao.findCollaborateurById(comId) ;
		colDao.removeCollaborateur(c);
		return c ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCollaborateur(Collaborateur c) {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		colDao.addCollaborateur(c) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCollaborateur(@PathParam("id") Long comId, Collaborateur c) {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		colDao.editCollaborateur(c);
	}
	
}
