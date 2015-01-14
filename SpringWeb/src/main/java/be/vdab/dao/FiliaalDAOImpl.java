package be.vdab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Filiaal;

// enkele imports ...
@Repository
class FiliaalDAOImpl implements FiliaalDAO {
	private EntityManager entityManager;
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}
	@Override
	public void create(Filiaal filiaal) {
		try {
			entityManager.persist(filiaal);
		} catch (RuntimeException ex) {
			entityManager.clear(); 
			throw ex;
		}
	}
	@Override
	public Filiaal read(long id) {
		return entityManager.find(Filiaal.class, id);
	}
	@Override
	public void update(Filiaal filiaal) {
		try {
		entityManager.merge(filiaal); 
		entityManager.flush(); 
		}
		catch (RuntimeException ex) {
			entityManager.clear();
			throw ex;
		}
	}
	@Override
	public void delete(long id) {
		Filiaal filiaal = entityManager.find(Filiaal.class, id);
		if (filiaal != null) {
			entityManager.remove(filiaal);
			entityManager.flush(); 
		}
	}
	@Override
	public List<Filiaal> findAll() {
		TypedQuery<Filiaal> query =
		entityManager.createNamedQuery("findAllFilialen", Filiaal.class);
		return query.getResultList();
	}
	@Override
	public List<Filiaal> findByPostcode(int van, int tot) {
		TypedQuery<Filiaal> query =
		entityManager.createNamedQuery("findFilialenByPostcode", Filiaal.class);
		query.setParameter("van", van);
		query.setParameter("tot", tot);
		return query.getResultList();
	}
	@Override
	public int findAantalFilialen() {
		TypedQuery<Number> query =
		entityManager.createNamedQuery("findAantalFilialen", Number.class);
		return query.getSingleResult().intValue();
	}
	@Override
	public Filiaal findByNaam(String naam) {
		TypedQuery<Filiaal> query =
		entityManager.createNamedQuery("findFiliaalByNaam", Filiaal.class);
		query.setParameter("naam", naam);
		try {
			return query.getSingleResult();
		}
		catch (NoResultException ex) { // geen record gevonden
			return null;
		}
	}
}