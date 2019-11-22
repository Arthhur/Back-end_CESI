package com.cesi.supcommerce.rest;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import fr.cesi.commerce.dao.jpa.JpaProjetDao;
import fr.cesi.commerce.dao.jpa.JpaReunionDao;
import fr.cesi.commerce.entity.Collaborateur;
import fr.cesi.commerce.entity.Projet;
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
	@Path("/reunion/{id}")
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
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reunion removeReunion(@PathParam("id") Long comId) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		Reunion r = reunionDao.findReunionById(comId) ;
		reunionDao.removeReunion(r);
		return r ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Reunion addReunion(String incomingData) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		String date = "" ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss"); //  04/02/2011 20:27:05
		String lieu = "" ;
		String objectif = "" ;
		Long id_createur = 0L ;
		Long id_projet = 0L ;
		JSONObject json =  new JSONObject();		
		try {
            JSONObject obj = new JSONObject(incomingData);
            
            date =obj.getString("date");
            lieu = obj.getString("lieu");
            objectif = obj.getString("objectif");
            id_createur = Long.parseLong(obj.getString("id_createur"));
            id_projet = Long.parseLong(obj.getString("projet"));
            Reunion r = new Reunion() ;
            r.setDate(date);
            r.setLieu(lieu);
            r.setObjectif(objectif);
            Collaborateur c = colDao.findCollaborateurById(id_createur) ;
            r.setCreateur(c);
            Projet p = projetDao.findProjetById(id_projet) ;
            r.setProjet(p);
            
            reunionDao.addReunion(r) ;
            return r ;
        } catch (Exception e) {
        	System.out.println(e) ;
        	return null ;
        }
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editReunion(@PathParam("id") Long comId, Reunion r) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		reunionDao.editReunion(r);
	}
	
}
