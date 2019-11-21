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
import fr.cesi.commerce.entity.Service;

@Path("/commentaires") 
public class CommentaireRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> getAllCommentairesInJson() {
		JpaCollaborateurDao commDao = (JpaCollaborateurDao)DaoFactory.getCommentaireDao() ;
		return commDao.getAllCommentaires() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur getCommentaireInJson(@PathParam("id") Long comId) {
		JpaCollaborateurDao commDao = (JpaCollaborateurDao)DaoFactory.getCommentaireDao() ;
		return commDao.findCommentaireById(comId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur removeCommentaire(@PathParam("id") Long comId) {
		JpaCollaborateurDao commDao = (JpaCollaborateurDao)DaoFactory.getCommentaireDao() ;
		Collaborateur c = commDao.findCommentaireById(comId) ;
		commDao.removeCommentaire(c);
		return c ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCommentaire(Collaborateur c) {
		JpaCollaborateurDao commDao = (JpaCollaborateurDao)DaoFactory.getCommentaireDao() ;
		commDao.addCommentaire(c) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCommentaire(@PathParam("id") Long comId, Collaborateur c) {
		JpaCollaborateurDao commDao = (JpaCollaborateurDao)DaoFactory.getCommentaireDao() ;
		commDao.editCommentaire(c);
	}
	
}
