package be.vdab.video.services;

import java.util.List;

import be.vdab.video.entities.Film;

public interface FilmService {
	public List<Film> findFilmByGenre(int genreNummer);
	public Film findFilmByNr(int nummer);
	public void reserveerExemplaar(int filmNr);
}
