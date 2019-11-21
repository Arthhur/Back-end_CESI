package fr.cesi.commerce.dao.jpa;

import fr.cesi.commerce.dao.CollaborateurDao;
import fr.cesi.commerce.dao.ReunionDao;
import fr.cesi.commerce.dao.RoleDao;
import fr.cesi.commerce.dao.TacheDao;
import fr.cesi.commerce.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	public static CollaborateurDao getCollaborateurDao() {
		return new JpaCollaborateurDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static ReunionDao getReunionDao() {
		return new JpaReunionDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static RoleDao getRoleDao() {
		return new JpaRoleDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static TacheDao getTacheDao() {
		return new JpaTacheDao(PersistenceManager.getEntityManagerFactory());
	}

}
