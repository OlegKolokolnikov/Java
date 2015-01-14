package be.vdab.video.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import be.vdab.video.entities.Klant;

public class KlantDAO extends AbstractDAO{
	public List<Klant> findKlantenByName(String naam){
		TypedQuery<Klant> query = getEntityManager().createNamedQuery(
				"findKlantenByName", Klant.class);
		query.setParameter("naam", "%" + naam + "%");
		return query.getResultList();
	}
	public Klant findKlantenByNr(int nummer){
		return getEntityManager().find(Klant.class, nummer);
	}
}
