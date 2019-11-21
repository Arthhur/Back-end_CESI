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
import fr.cesi.commerce.dao.jpa.JpaCommentaireDao;
import fr.cesi.commerce.entity.Commentaire;
import fr.cesi.commerce.entity.Service;

@Path("/commentaires") 
public class CommentaireRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commentaire> getAllCommentairesInJson() {
		JpaCommentaireDao commDao = (JpaCommentaireDao)DaoFactory.getCommentaireDao() ;
		return commDao.getAllCommentaires() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Commentaire getCommentaireInJson(@PathParam("id") Long comId) {
		JpaCommentaireDao commDao = (JpaCommentaireDao)DaoFactory.getCommentaireDao() ;
		return commDao.findCommentaireById(comId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Commentaire removeCommentaire(@PathParam("id") Long comId) {
		JpaCommentaireDao commDao = (JpaCommentaireDao)DaoFactory.getCommentaireDao() ;
		Commentaire c = commDao.findCommentaireById(comId) ;
		commDao.removeCommentaire(c);
		return c ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCommentaire(Commentaire c) {
		JpaCommentaireDao commDao = (JpaCommentaireDao)DaoFactory.getCommentaireDao() ;
		commDao.addCommentaire(c) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCommentaire(@PathParam("id") Long comId, Commentaire c) {
		JpaCommentaireDao commDao = (JpaCommentaireDao)DaoFactory.getCommentaireDao() ;
		commDao.editCommentaire(c);
	}
	
}
