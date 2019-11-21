package fr.cesi.commerce.dao;

import java.util.List;

import fr.cesi.commerce.entity.Role;
import fr.cesi.commerce.entity.Role;

public interface RoleDao {

	public Role addRole(Role r) ;
	public void editRole(Role r) ;
	public List<Role> getAllRoles() ;
	public Role findRoleById(Long id) ;
	public void removeRole(Role r) ;
}
