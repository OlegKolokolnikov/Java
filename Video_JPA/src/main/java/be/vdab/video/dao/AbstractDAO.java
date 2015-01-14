package be.vdab.video.dao;

import javax.persistence.EntityManager;

import be.vdab.video.filters.JPAFilter;

public abstract class AbstractDAO {

	public AbstractDAO() {
		super();
	}

	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager(); 
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		getEntityManager().getTransaction().rollback();
	}

}