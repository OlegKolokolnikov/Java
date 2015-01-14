package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.FiliaalDAO;
import be.vdab.entities.Filiaal;
import be.vdab.exceptions.FiliaalHeeftNogWerknemersException;
import be.vdab.exceptions.FiliaalMetDezeNaamBestaatAlException;
@Service
@Transactional(readOnly = true)
public class FiliaalServiceImpl implements FiliaalService{
	private final FiliaalDAO filiaalDAO;
	@Autowired
	public FiliaalServiceImpl(FiliaalDAO filiaalDAO) {
		this.filiaalDAO = filiaalDAO;
	}
	@Override
	@Transactional(readOnly=false)
	public void create(Filiaal filiaal) {
		try {
			filiaalDAO.create(filiaal);
		}
		catch (DataIntegrityViolationException ex) {
			if (filiaalDAO.findByNaam(filiaal.getNaam()) != null) {
				throw new FiliaalMetDezeNaamBestaatAlException();
			}
			throw ex;
		}
	}
	@Override
	public Filiaal read(long id) {
	return filiaalDAO.read(id);
	}
	@Override
	@Transactional(readOnly=false)
	public void update(Filiaal filiaal) {
		try {
			filiaalDAO.update(filiaal);
		} catch (DataIntegrityViolationException ex) {
			if (filiaalDAO.findByNaam(filiaal.getNaam()) != null) {
				throw new FiliaalMetDezeNaamBestaatAlException();
			}
			throw ex;
		}
	}
	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		Filiaal filiaal = filiaalDAO.read(id);
		if ( ! filiaal.getWerknemers().isEmpty()) {
			throw new FiliaalHeeftNogWerknemersException();
		}
		filiaalDAO.delete(id);
	}
	@Override
	public List<Filiaal> findAll() {
	return filiaalDAO.findAll();
	}
	@Override
	public List<Filiaal> findByPostcode(int van, int tot) {
	return filiaalDAO.findByPostcode(van, tot);
	}
	@Override
	public int findAantalFilialen() {
	return filiaalDAO.findAantalFilialen();
	}
}
