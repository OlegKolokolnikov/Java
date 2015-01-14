package be.vdab.video.dao;

import be.vdab.video.entities.Reservatie;

public class ReservatieDAO extends AbstractDAO {
	
	public void create (Reservatie reservatie){
		getEntityManager().persist(reservatie);
	}
}
