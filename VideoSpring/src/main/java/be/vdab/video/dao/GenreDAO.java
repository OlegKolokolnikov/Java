package be.vdab.video.dao;

import java.util.List;

import be.vdab.video.entities.Genre;

public interface GenreDAO {
	public List<Genre> findAll();
}
