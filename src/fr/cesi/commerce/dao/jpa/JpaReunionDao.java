package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.ReunionDao;
import fr.cesi.commerce.entity.Reunion;

public class JpaReunionDao implements ReunionDao{
	private EntityManagerFactory emf ;
	
	public JpaReunionDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Reunion addReunion(Reunion r) {
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
	public void editReunion(Reunion r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Reunion reunion = new Reunion();
		try {
			t.begin();
			reunion = em.merge(r); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Reunion> getAllReunions() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Reunion R ");
		return query.getResultList();
	}
	public Reunion findReunionById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Reunion R WHERE R.id = ?1");
		query.setParameter(1, id) ;
		return (Reunion)query.getSingleResult() ;
	}
	public void removeReunion(Reunion r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(r) ? r : em.merge(r));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Reunion> findReunionByProjet(Long pId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Reunion R WHERE R.projet = ?1");
		query.setParameter(1, pId) ;
		return (List<Reunion>)query.getResultList();
	}

}
