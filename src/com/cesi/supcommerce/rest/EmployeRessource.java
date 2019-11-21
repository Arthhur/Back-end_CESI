package com.cesi.supcommerce.rest;

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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import fr.cesi.commerce.dao.jpa.DaoFactory;
import fr.cesi.commerce.dao.jpa.JpaEmployeDao;
import fr.cesi.commerce.dao.jpa.JpaRoleDao;
import fr.cesi.commerce.dao.jpa.JpaServiceDao;
import fr.cesi.commerce.entity.role;
import fr.cesi.commerce.entity.Role;
import fr.cesi.commerce.entity.Service;

@Path("/employes") 
public class EmployeRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<role> getAllEmployesInJson() {
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		return empDao.getAllEmployes() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public role getEmployeInJson(@PathParam("id") Long empId) {
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		return empDao.findEmployeById(empId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public role removeEmploye(@PathParam("id") Long empId) {
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		role e = empDao.findEmployeById(empId) ;
		empDao.removeEmploye(e);
		return e ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEmploye(role emp) throws JSONException {
		/*JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		JpaServiceDao serviceDao = (JpaServiceDao)DaoFactory.getServiceDao() ;
		JSONObject jsonObj = new JSONObject(emp) ;
		String nom = jsonObj.getString("nom") ;
		String prenom = jsonObj.getString("prenom") ;
		String sexe = jsonObj.getString("sexe") ;
		String email = jsonObj.getString("email") ;
		String pass = jsonObj.getString("pass") ;
		String date = jsonObj.getString("date_naissance") ;
		String role_id = jsonObj.getString("role_id") ;
		String service_id = jsonObj.getString("service_id") ;
		Employe e = new Employe() ;
		Role role = roleDao.findRoleById(Long.parseLong(role_id)) ;
		Service service = serviceDao.findServiceById(Long.parseLong(role_id)) ;
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setSexe(sexe);
		e.setEmail(email);
		e.setPass(pass);
		e.setDate_naissance(date);
		e.setRole(role);
		e.setService(service);*/
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		empDao.addEmploye(emp) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editEmploye(@PathParam("id") Long empId, role e) {
		JpaEmployeDao empDao = (JpaEmployeDao)DaoFactory.getEmployeDao() ;
		empDao.editEmploye(e);
	}
	
}
