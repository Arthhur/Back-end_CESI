package fr.cesi.commerce.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.commerce.dao.RoleDao;
import fr.cesi.commerce.entity.Role;

public class JpaRoleDao implements RoleDao{
	private EntityManagerFactory emf ;
	
	public JpaRoleDao(EntityManagerFactory emf) {
		this.emf = emf ;
	}
	
	public Role addRole(Role r) {
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
	public void editRole(Role r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();	
		Role role = new Role();
		try {
			t.begin();
			role = em.merge(r); 
			t.commit();
		} finally {
			if (t.isActive()) 
				t.rollback();
			em.close();
		}
	}
	public List<Role> getAllRoles() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Role R ");
		return query.getResultList();
	}
	public Role findRoleById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Query query = em.createQuery("FROM Role R WHERE R.id = ?1");
		query.setParameter(1, id) ;
		return (Role)query.getSingleResult() ;
	}
	public void removeRole(Role r) {
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

}
