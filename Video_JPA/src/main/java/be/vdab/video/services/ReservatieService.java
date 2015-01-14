package be.vdab.video.services;


import be.vdab.video.dao.FilmDAO;
import be.vdab.video.dao.ReservatieDAO;
import be.vdab.video.entities.Reservatie;

public class ReservatieService {
	ReservatieDAO reservatieDAO = new ReservatieDAO();
	FilmDAO filmDAO = new FilmDAO();
	
	public void create(Reservatie reservatie) {
		reservatieDAO.beginTransaction();
		reservatieDAO.create(reservatie);
		reservatieDAO.commit();
	}
}
