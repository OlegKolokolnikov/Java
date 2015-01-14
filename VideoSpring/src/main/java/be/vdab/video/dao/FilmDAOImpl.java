package be.vdab.video.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.video.entities.Film;

@Repository
public class FilmDAOImpl implements FilmDAO{
	private EntityManager entityManager;
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}
	@Override
	public List<Film> findFilmByGenre(int genreNummer){
		TypedQuery<Film> query = entityManager.createNamedQuery(
				"findFilmByGenre", Film.class);
		query.setParameter("genreNr", genreNummer);
		return query.getResultList();
	}
	@Override
	public Film findFilmByNr(int nummer) {
			return entityManager.find(Film.class, nummer);
	}
	@Override
	public int reserveerExemplaar(int filmNr){
		Query query =entityManager.createNamedQuery("reserveerExemplaar");
		query.setParameter("filmNr", filmNr);
		return query.executeUpdate();
	}
}
