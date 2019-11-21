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
import fr.cesi.commerce.dao.jpa.JpaReunionDao;
import fr.cesi.commerce.entity.Reunion;

@Path("/reunions") 
public class ReunionRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reunion> getAllReunionsInJson() {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		return reunionDao.getAllReunions() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reunion getReunionInJson(@PathParam("id") Long comId) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		return reunionDao.findReunionById(comId) ;
	}
	
	@GET
	@Path("/{idProjet}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reunion> getReunionByProjetInJson(@PathParam("idProjet") Long pId) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		return reunionDao.findReunionByProjet(pId);
	}
	
	@GET 
	@Path("/reunion/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reunion removeReunion(@PathParam("id") Long comId) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		Reunion r = reunionDao.findReunionById(comId) ;
		reunionDao.removeReunion(r);
		return r ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addReunion(Reunion r) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		reunionDao.addReunion(r) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editReunion(@PathParam("id") Long comId, Reunion r) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		reunionDao.editReunion(r);
	}
	
}
