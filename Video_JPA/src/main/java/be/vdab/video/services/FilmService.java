package be.vdab.video.services;

import java.util.List;

import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;



import be.vdab.video.dao.FilmDAO;
import be.vdab.video.entities.Film;
import be.vdab.video.exceptions.FilmNietGevondenException;
import be.vdab.video.exceptions.RecordAangepastException;

public class FilmService {
	private final FilmDAO filmDAO = new FilmDAO();
	
	public List<Film> findFilmByGenre(int genreNummer) {
		return filmDAO.findFilmByGenre(genreNummer);
	}
	
	public Film findFilmByNr(int nummer) {
		return filmDAO.findFilmByNr(nummer);
	}
	public void reserveerExemplaar(int filmNr){
		filmDAO.beginTransaction();
		Film film = filmDAO.findFilmByNr(filmNr);
		if (film == null) {
			throw new FilmNietGevondenException();
		}
		film.reserveer(film.getGereserveerd());
		try {
			filmDAO.commit();
		} catch (RollbackException ex) { 
			if (ex.getCause() instanceof OptimisticLockException) { 
					throw new RecordAangepastException();
			}
		}
	}
}
