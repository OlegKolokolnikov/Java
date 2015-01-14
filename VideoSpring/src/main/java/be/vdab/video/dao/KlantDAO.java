package be.vdab.video.dao;

import java.util.List;


import be.vdab.video.entities.Klant;

public interface KlantDAO {
	public List<Klant> findKlantenByName(String naam);
	public Klant findKlantenByNr(int nummer);
}
