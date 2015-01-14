package be.vdab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Werknemer;

@Repository
class WerknemerDAOImpl implements WerknemerDAO {
	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Werknemer> findAll() {
		TypedQuery<Werknemer> query =
				entityManager.createNamedQuery("findAllWerknemers", Werknemer.class);
		return query.getResultList();
	}
}