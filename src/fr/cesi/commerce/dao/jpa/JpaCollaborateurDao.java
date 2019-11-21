package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.CollaborateurDao;
import fr.cesi.commerce.entity.Collaborateur;

public class JpaCollaborateurDao implements CollaborateurDao{
	private EntityManagerFactory emf ;
	
	public JpaCollaborateurDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Collaborateur addCollaborateur(Collaborateur c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(c) ? c : em.merge(c)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return c ;
	}
	public void editCollaborateur(Collaborateur c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Collaborateur col = new Collaborateur();
		try {
			t.begin();
			col = em.merge(c); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Collaborateur> getAllCollaborateurs() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Collaborateur C ");
		return query.getResultList();
	}
	public Collaborateur findCollaborateurById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Collaborateur C WHERE C.id = ?1");
		query.setParameter(1, id) ;
		return (Collaborateur)query.getSingleResult() ;
	}
	public void removeCollaborateur(Collaborateur c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(c) ? c : em.merge(c));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public Collaborateur getCollaborateur(String mail, String pwd){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = em.createQuery("FROM Collaborateur C WHERE C.mail = ?1 and C.pwd = ?2");
		query.setParameter(1, mail) ;
		query.setParameter(2, pwd) ;
		return (Collaborateur)query.getSingleResult() ;
	}
	
	public List<String> getTest(String mail, String pwd){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query query = em.createNativeQuery("SELECT CONCAT(nom, ' ', prenom), mail FROM Collaborateur C WHERE C.mail = ?1 and C.pwd = ?2 ");
		query.setParameter(1, mail) ;
		query.setParameter(2, pwd) ;
		List<String> results = query.getResultList();
	    if (results.isEmpty()) 
	    	return null;
		return results ;
	}

}
