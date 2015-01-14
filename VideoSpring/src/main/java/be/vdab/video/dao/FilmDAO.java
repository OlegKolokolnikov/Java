package be.vdab.video.dao;

import java.util.List;

import be.vdab.video.entities.Film;

public interface FilmDAO {
	public List<Film> findFilmByGenre(int genreNummer);
	public Film findFilmByNr(int nummer);
	public int reserveerExemplaar(int filmNr);
}
