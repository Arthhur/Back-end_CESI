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
import fr.cesi.commerce.dao.jpa.JpaEmployeDao;
import fr.cesi.commerce.entity.Collaborateur;
import fr.cesi.commerce.entity.role;
import fr.cesi.commerce.entity.Service;

@Path("/connexion") 
public class ConnexionRessource {
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public role getConnexion(role e) {
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		return empDao.connexionEmp(e.getNom(), e.getPass()) ;
	}
	
}
