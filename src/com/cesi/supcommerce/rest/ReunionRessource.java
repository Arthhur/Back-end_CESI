package com.cesi.supcommerce.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
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
	public boolean addReunion(String incomingData) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		String date = "" ;
		String lieu = "" ;
		String objectif = "" ;
		Long id_createur = 0L ;
		Long id_projet = 0L ;
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>() ;
		JSONArray idCollab = new JSONArray() ;
		try {
            JSONObject obj = new JSONObject(incomingData);
            
            date = obj.getString("date");
            lieu = obj.getString("lieu");
            objectif = obj.getString("objectif");
            id_createur = Long.parseLong(obj.getString("id_createur"));
            id_projet = Long.parseLong(obj.getString("projet"));
            idCollab = obj.getJSONArray("collaborateurs") ;
            for (int i = 0; i < idCollab.length(); i++) {
            	Long id = Long.parseLong((String) idCollab.get(i)) ;
                Collaborateur c = colDao.findCollaborateurById(id);
                collaborateurs.add(c) ;
            }
            
            Reunion r = new Reunion() ;
            r.setDate(date);
            r.setLieu(lieu);
            r.setObjectif(objectif);
            Collaborateur c = colDao.findCollaborateurById(id_createur) ;
            r.setCreateur(c);
            Projet p = projetDao.findProjetById(id_projet) ;
            r.setProjet(p);
            r.setParticipant(collaborateurs);
            
            reunionDao.addReunion(r) ;
            return true ;
        } catch (Exception e) {
        	System.out.println(e) ;
        	return false ;
        }
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Reunion editReunion(@PathParam("id") Long comId, String incomingData) {
		JpaReunionDao reunionDao = (JpaReunionDao)DaoFactory.getReunionDao() ;
		JpaCollaborateurDao colDao = (JpaCollaborateurDao)DaoFactory.getCollaborateurDao() ;
		JpaProjetDao projetDao = (JpaProjetDao)DaoFactory.getProjetDao() ;
		String date = "" ;
		String lieu = "" ;
		String objectif = "" ;
		Long id_reunion = 0L ;
		Long id_createur = 0L ;
		Long id_projet = 0L ;
		Reunion r = new Reunion() ;
		List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>() ;
		JSONArray idCollab = new JSONArray() ;
		try {
            JSONObject obj = new JSONObject(incomingData);
            id_reunion = Long.parseLong(obj.getString("id")) ;
            date = obj.getString("date");
            lieu = obj.getString("lieu");
            objectif = obj.getString("objectif");
            id_createur = Long.parseLong(obj.getString("id_createur"));
            id_projet = Long.parseLong(obj.getString("projet"));
            idCollab = obj.getJSONArray("collaborateurs") ;
            for (int i = 0; i < idCollab.length(); i++) {
            	Long id = Long.parseLong((String) idCollab.get(i)) ;
                Collaborateur c = colDao.findCollaborateurById(id);
                collaborateurs.add(c) ;
            }
            
            r = reunionDao.findReunionById(id_reunion) ;
            
            r.setDate(date);
            r.setLieu(lieu);
            r.setObjectif(objectif);
            Collaborateur c = colDao.findCollaborateurById(id_createur) ;
            r.setCreateur(c);
            Projet p = projetDao.findProjetById(id_projet) ;
            r.setProjet(p);
            r.setParticipant(collaborateurs);
            
            reunionDao.editReunion(r) ;
            return r ;
        } catch (Exception e) {
        	System.out.println(e) ;
        	return null;
        }
	}
	
}
