package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.WerknemerDAO;
import be.vdab.entities.Werknemer;

@Service
@Transactional(readOnly = true)
public class WerknemerServiceImpl implements WerknemerService{
	private final WerknemerDAO werknemerDAO;
	@Autowired
	public WerknemerServiceImpl(WerknemerDAO werknemerDAO) {
		this.werknemerDAO = werknemerDAO;
	}
	@Override
	public List<Werknemer> findAll() {
		return werknemerDAO.findAll();
	}
}
