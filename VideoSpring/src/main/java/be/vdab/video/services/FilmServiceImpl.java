package be.vdab.video.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.video.dao.FilmDAO;
import be.vdab.video.entities.Film;
import be.vdab.video.exceptions.FilmNietGevondenException;
@Service
@Transactional(readOnly = true)
public class FilmServiceImpl implements FilmService{
	private final FilmDAO filmDAO;
	@Autowired
	public FilmServiceImpl(FilmDAO filmDAO){
		this.filmDAO=filmDAO;
	}
	public List<Film> findFilmByGenre(int genreNummer) {
		return filmDAO.findFilmByGenre(genreNummer);
	}
	
	public Film findFilmByNr(int nummer) {
		return filmDAO.findFilmByNr(nummer);
	}
	@Transactional(readOnly = false)
	public void reserveerExemplaar(int filmNr){
		Film film = filmDAO.findFilmByNr(filmNr);
		if (film == null) {
			throw new FilmNietGevondenException();
		}
		film.reserveer(film.getGereserveerd());
		
	}
}
