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

@Path("/connexion") 
public class ConnexionRessource {
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean getConnexion(String incomingData) {
		String mail = "" ;
		String password = "" ;
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		try {
            JSONObject obj = new JSONObject(incomingData);
            mail = obj.getString("mail");
            password = obj.getString("password");
        } catch (Exception e) {
        	System.out.println(e) ;
        	return false ;
        }
		System.out.println(colDao.getCollaborateur(mail, password)) ;
		return false ;
		/*if (!colDao.getCollaborateur(mail, password).equals(null)){

			return true;
		}
		else 
			return false;*/
		
	}
	
}
