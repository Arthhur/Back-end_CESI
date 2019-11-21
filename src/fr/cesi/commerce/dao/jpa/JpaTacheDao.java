package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.TacheDao;
import fr.cesi.commerce.entity.Tache;

public class JpaTacheDao implements TacheDao{
	private EntityManagerFactory emf ;
	
	public JpaTacheDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Tache addTache(Tache r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(r) ? r : em.merge(r)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return r ;
	}
	public void editTache(Tache task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Tache tache = new Tache();
		try {
			t.begin();
			tache = em.merge(task); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Tache> getAllTaches() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Tache T ");
		return query.getResultList();
	}
	public Tache findTacheById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Tache T WHERE T.id = ?1");
		query.setParameter(1, id) ;
		return (Tache)query.getSingleResult() ;
	}
	public void removeTache(Tache tache) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(tache) ? tache : em.merge(tache));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}

}
