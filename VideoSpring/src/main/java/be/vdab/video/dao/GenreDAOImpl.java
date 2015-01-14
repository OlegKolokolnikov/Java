package be.vdab.video.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.video.entities.Genre;
@Repository
public class GenreDAOImpl  implements GenreDAO{
	private EntityManager entityManager;
	
	
	@PersistenceContext 
	public void setEntityManager(EntityManager entityManager) { 
		this.entityManager = entityManager;
	}
	@Override
	public List<Genre> findAll() {
		TypedQuery<Genre> query =entityManager.createNamedQuery(
				"findGenres", Genre.class);
		return query.getResultList();
	}
}
