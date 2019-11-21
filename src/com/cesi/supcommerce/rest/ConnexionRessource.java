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

@Path("/connexion") 
public class ConnexionRessource {
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean getConnexion(String mail, String pwd) {
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		if (!colDao.getCollaborateur(mail, pwd).equals([])){
			return true;
		}
		else return false;
		
	}
	
}
