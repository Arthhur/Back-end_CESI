package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.TacheDao;
import fr.cesi.commerce.entity.Tache;
import fr.cesi.commerce.entity.Tache;
import fr.cesi.commerce.entity.Tache;

public class JpaTacheDao implements TacheDao{
	private EntityManagerFactory emf ;
	
	public JpaTacheDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Tache addTache(Tache task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(task) ? task : em.merge(task)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return task ;
	}
	public void editTache(Tache task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Tache tsk ;
		try {
			t.begin();
			tsk = em.merge(task); 
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
	public void removeTache(Tache task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(task) ? task : em.merge(task));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}

}
