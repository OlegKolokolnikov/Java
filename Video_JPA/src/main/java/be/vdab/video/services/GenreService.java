package be.vdab.video.services;

import java.util.List;

import be.vdab.video.dao.GenreDAO;
import be.vdab.video.entities.Genre;

public class GenreService {
	private final GenreDAO genreDAO = new GenreDAO();
	
	public List<Genre> findAll() {   
		return genreDAO.findAll(); 
	}
	 
}
