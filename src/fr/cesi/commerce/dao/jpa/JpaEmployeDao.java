package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.cesi.commerce.dao.EmployeDao;
import fr.cesi.commerce.entity.Employe;
import fr.cesi.commerce.entity.Projet;
import fr.cesi.commerce.entity.Service;

public class JpaEmployeDao implements EmployeDao{
	private EntityManagerFactory emf ;
	
	public JpaEmployeDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Employe addEmploye(Employe e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.persist(em.contains(e) ? e : em.merge(e)); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
		return e ;
	}
	public void editEmploye(Employe e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Employe emp ;
		try {
			t.begin();
			emp = em.merge(e); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Employe> getAllEmployes() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Employe E ");
		return query.getResultList();
	}
	public Employe findEmployeById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Employe E WHERE E.id = ?1");
		query.setParameter(1, id) ;
		return (Employe)query.getSingleResult() ;
	}
	public void removeEmploye(Employe e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		try {
			t.begin();
			em.remove(em.contains(e) ? e : em.merge(e));
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	
	public Employe connexionEmp(String nom, String pass) {
		Employe emp = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Employe E WHERE E.nom = :nom AND E.pass = :pass");
		query.setParameter("nom", nom) ;
		query.setParameter("pass", pass) ;
		try {
			emp = (Employe)query.getSingleResult() ;
		}
		catch (NoResultException nre){
		
		}
		return emp ;
	}

}
