package be.vdab.video.services;

import java.util.List;

import be.vdab.video.dao.KlantDAO;
import be.vdab.video.entities.Klant;

public class KlantService {
	private final KlantDAO klantDAO = new KlantDAO();
	
	public List<Klant> findKlantenByName(String naam){
		return klantDAO.findKlantenByName(naam);
	}
	public Klant findKlantenByNr(int nummer) {
		return klantDAO.findKlantenByNr(nummer);
		
	}
}
