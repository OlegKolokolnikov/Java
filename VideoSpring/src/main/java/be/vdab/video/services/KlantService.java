package be.vdab.video.services;

import java.util.List;

import be.vdab.video.entities.Klant;

public interface KlantService {
	public List<Klant> findKlantenByName(String naam);
	public Klant findKlantenByNr(int nummer);
}
