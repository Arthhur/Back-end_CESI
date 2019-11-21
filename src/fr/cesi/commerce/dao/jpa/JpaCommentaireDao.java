package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.CommentaireDao;
import fr.cesi.commerce.entity.Commentaire;
import fr.cesi.commerce.entity.Commentaire;
import fr.cesi.commerce.entity.Service;

public class JpaCommentaireDao implements CommentaireDao{
	private EntityManagerFactory emf ;
	
	public JpaCommentaireDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Commentaire addCommentaire(Commentaire c) {
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
	public void editCommentaire(Commentaire c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Commentaire com ;
		try {
			t.begin();
			com = em.merge(c); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Commentaire> getAllCommentaires() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Commentaire C ");
		return query.getResultList();
	}
	public Commentaire findCommentaireById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Commentaire C WHERE C.id = ?1");
		query.setParameter(1, id) ;
		return (Commentaire)query.getSingleResult() ;
	}
	public void removeCommentaire(Commentaire c) {
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

}
