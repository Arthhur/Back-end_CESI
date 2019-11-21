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

import org.codehaus.jettison.json.JSONObject;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaCollaborateurDao;
import fr.cesi.commerce.entity.Collaborateur;

@Path("/connexion") 
public class ConnexionRessource {
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collaborateur getConnexion(String incomingData) {
		String mail = "" ;
		String password = "" ;
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		try {
            JSONObject obj = new JSONObject(incomingData);
            mail = obj.getString("mail");
            password = obj.getString("password");
        } catch (Exception e) {
        	System.out.println(e) ;
        	return null ;
        }
<<<<<<< HEAD
		if (colDao.getCollaborateur(mail, password) == null){
			return null ;
		}
		else {
			return colDao.getCollaborateur(mail, password) ;
=======
		System.out.println(colDao.getCollaborateur(mail, password)) ;
		return false ;
		/*if (!colDao.getCollaborateur(mail, password).equals(null)){

			return true;
>>>>>>> 5a712e7866ad573a80672340a98bdce8931d1a9f
		}
	}
	
}
