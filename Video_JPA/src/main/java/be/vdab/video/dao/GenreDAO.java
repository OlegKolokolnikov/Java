package be.vdab.video.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import be.vdab.video.entities.Genre;

public class GenreDAO extends AbstractDAO{

	public List<Genre> findAll() {
		TypedQuery<Genre> query =getEntityManager().createNamedQuery(
				"findGenres", Genre.class);
		return query.getResultList();
	}
}
