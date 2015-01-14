package be.vdab.video.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.video.dao.KlantDAO;
import be.vdab.video.entities.Klant;
@Service
@Transactional(readOnly = true)
public class KlantServiceImpl implements KlantService{
	private final KlantDAO klantDAO;
	@Autowired
	public KlantServiceImpl(KlantDAO klantDAO){
		this.klantDAO=klantDAO;
	}
	public List<Klant> findKlantenByName(String naam){
		return klantDAO.findKlantenByName(naam);
	}
	public Klant findKlantenByNr(int nummer) {
		return klantDAO.findKlantenByNr(nummer);
		
	}
}
