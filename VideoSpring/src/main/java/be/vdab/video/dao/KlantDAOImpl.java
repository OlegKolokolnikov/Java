package be.vdab.video.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.video.entities.Klant;
@Repository
public class KlantDAOImpl  implements KlantDAO{
	private EntityManager entityManager;
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}
	@Override
	public List<Klant> findKlantenByName(String naam){
		TypedQuery<Klant> query = entityManager.createNamedQuery(
				"findKlantenByName", Klant.class);
		query.setParameter("naam", "%" + naam + "%");
		return query.getResultList();
	}
	@Override
	public Klant findKlantenByNr(int nummer){
		return entityManager.find(Klant.class, nummer);
	}
}
