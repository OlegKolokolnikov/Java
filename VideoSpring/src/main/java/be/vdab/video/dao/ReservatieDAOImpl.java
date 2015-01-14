package be.vdab.video.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import be.vdab.video.entities.Reservatie;
@Repository
public class ReservatieDAOImpl  implements ReservatieDAO{
	private EntityManager entityManager;
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}
	@Override
	public void create (Reservatie reservatie){
		try {
		entityManager.persist(reservatie);
		
		} catch (RuntimeException ex) {
			entityManager.clear(); 
			throw ex;
		}
	}
}
