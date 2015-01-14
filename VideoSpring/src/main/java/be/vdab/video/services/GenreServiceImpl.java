package be.vdab.video.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.video.dao.GenreDAO;
import be.vdab.video.entities.Genre;
@Service
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService{
	private final GenreDAO genreDAO;
	@Autowired
	public GenreServiceImpl(GenreDAO genreDAO){
		this.genreDAO=genreDAO;
	}
	public List<Genre> findAll() {   
		return genreDAO.findAll(); 
	}
	 
}
