package be.vdab.dao;

import java.util.List;

import be.vdab.entities.Filiaal;

public interface FiliaalDAO {
	void create(Filiaal filiaal);
	Filiaal read(long id);
	void update(Filiaal filiaal);
	void delete(long id);
	List<Filiaal> findAll();
	List<Filiaal> findByPostcode(int van, int tot);
	int findAantalFilialen();
	Filiaal findByNaam(String naam);
}
