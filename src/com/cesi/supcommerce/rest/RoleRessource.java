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
import fr.cesi.commerce.dao.jpa.JpaRoleDao;
import fr.cesi.commerce.entity.Role;

@Path("/roles") 
public class RoleRessource {
		
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Role> getAllRolesInJson() {
		JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		return roleDao.getAllRoles() ;
	}
	
	@GET 
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role getRoleInJson(@PathParam("id") Long roleId) {
		JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		return roleDao.findRoleById(roleId) ;
	}
	
	@GET 
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Role removeRole(@PathParam("id") Long roleId) {
		JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		Role c = roleDao.findRoleById(roleId) ;
		roleDao.removeRole(c);
		return c ;
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRole(Role r) {
		JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		roleDao.addRole(r) ;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editRole(@PathParam("id") Long categorytId, Role c) {
		JpaRoleDao roleDao = (JpaRoleDao)DaoFactory.getRoleDao() ;
		roleDao.editRole(c);
	}
	
}
