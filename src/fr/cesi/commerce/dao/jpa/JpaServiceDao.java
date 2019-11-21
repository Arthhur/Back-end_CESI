package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.ServiceDao;
import fr.cesi.commerce.entity.Service;
import fr.cesi.commerce.entity.Service;
import fr.cesi.commerce.entity.Service;

public class JpaServiceDao implements ServiceDao{
	private EntityManagerFactory emf ;
	
	public JpaServiceDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Service addService(Service s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(s) ? s : em.merge(s)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return s ;
	}
	public void editService(Service s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Service service ;
		try {
			t.begin();
			service = em.merge(s); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Service> getAllServices() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Service S ");
		return query.getResultList();
	}
	public Service findServiceById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Service S WHERE S.id = ?1");
		query.setParameter(1, id) ;
		return (Service)query.getSingleResult() ;
	}
	public void removeService(Service s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(s) ? s : em.merge(s));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}

}
