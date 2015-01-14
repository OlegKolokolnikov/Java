package be.vdab.video.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.video.dao.ReservatieDAO;
import be.vdab.video.entities.Reservatie;
@Service
@Transactional(readOnly = false)
public class ReservatieServiceImpl implements ReservatieService{
	private final ReservatieDAO reservatieDAO;
	@Autowired
	public ReservatieServiceImpl(ReservatieDAO reservatieDAO){
		this.reservatieDAO=reservatieDAO;
	}
	public void create(Reservatie reservatie) {
		try {
			
		reservatieDAO.create(reservatie);
		}
		catch (DataIntegrityViolationException ex) {
			throw ex;
		}
	}
}
