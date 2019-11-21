package fr.cesi.commerce.dao.jpa;

import fr.cesi.commerce.dao.CommentaireDao;
import fr.cesi.commerce.util.PersistenceManager;

public class DaoFactory {
	
	private DaoFactory() {
		
	}
	public static CommentaireDao getCommentaireDao() {
		return new JpaCommentaireDao(PersistenceManager.getEntityManagerFactory());
	}

}
