package fr.cesi.commerce.dao.jpa;

import fr.cesi.commerce.dao.CommentaireDao;
import fr.cesi.commerce.dao.EmployeDao;
import fr.cesi.commerce.dao.ProjetDao;
import fr.cesi.commerce.dao.RoleDao;
import fr.cesi.commerce.dao.ServiceDao;
import fr.cesi.commerce.dao.TacheDao;
import fr.cesi.commerce.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	
	public static CommentaireDao getCommentaireDao() {
		return new JpaCommentaireDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static EmployeDao getEmployeDao() {
		return new JpaEmployeDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static ProjetDao getProjetDao() {
		return new JpaProjetDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static RoleDao getRoleDao() {
		return new JpaRoleDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static ServiceDao getServiceDao() {
		return new JpaServiceDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static TacheDao getTacheDao() {
		return new JpaTacheDao(PersistenceManager.getEntityManagerFactory());
	}

}
