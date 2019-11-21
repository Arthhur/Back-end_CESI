package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.ProjetDao;
import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Service;

public class JpaProjetDao implements ProjetDao{
	private EntityManagerFactory emf ;
	
	public JpaProjetDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Projet addProjet(Projet p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(p) ? p : em.merge(p)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return p ;
	}
	public void editProjet(Projet p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Projet projet ;
		try {
			t.begin();
			projet = em.merge(p); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Projet> getAllProjets() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Projet P ");
		return query.getResultList();
	}
	public Projet findProjetById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Projet P WHERE P.id = ?1");
		query.setParameter(1, id) ;
		return (Projet)query.getSingleResult() ;
	}
	public void removeProjet(Projet p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(p) ? p : em.merge(p));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}

}
