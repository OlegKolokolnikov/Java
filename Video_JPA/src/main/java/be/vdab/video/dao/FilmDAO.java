package be.vdab.video.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.vdab.video.entities.Film;


public class FilmDAO extends AbstractDAO{
	public List<Film> findFilmByGenre(int genreNummer){
		TypedQuery<Film> query = getEntityManager().createNamedQuery(
				"findFilmByGenre", Film.class);
		query.setParameter("genreNr", genreNummer);
		return query.getResultList();
	}

	public Film findFilmByNr(int nummer) {
			return getEntityManager().find(Film.class, nummer);
	}
	public int reserveerExemplaar(int filmNr){
		Query query =getEntityManager().createNamedQuery("reserveerExemplaar");
		query.setParameter("filmNr", filmNr);
		return query.executeUpdate();
	}
}
