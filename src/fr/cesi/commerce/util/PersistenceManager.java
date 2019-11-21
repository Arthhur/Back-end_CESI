package fr.cesi.commerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;

	private PersistenceManager(){
	}

	// Lazy initialization
	
	public static EntityManagerFactory
		getEntityManagerFactory(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("gestion");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) 
			emf.close();
	}
}
