package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Giocatore;
import it.dstech.computers.repository.IGiocatoreRepository;

@Service
public class GiocatoreService {
	
	@Autowired
	private IGiocatoreRepository dao;
	
	public Giocatore create (Giocatore giocatore) {
		return dao.save(giocatore);
	}
	public Giocatore findOne (Long id) throws Exception {
		return dao.findById(id).orElseThrow(()-> new Exception());
	}
	public Iterable<Giocatore> findAll() {
		return dao.findAll();
	}
	public void deleteOne(Long id) {
		dao.deleteById(id);
	}
	public void deleteAll() {
		dao.deleteAll();
	}
	public Giocatore update (Giocatore giocatoreInput) throws Exception {
		Giocatore giocatoreDb = findOne (giocatoreInput.getId());
		giocatoreDb.setNome(giocatoreInput.getNome());
		giocatoreDb.setCognome(giocatoreInput.getCognome());
		giocatoreDb.setSquadraReale(giocatoreInput.getSquadraReale());
		giocatoreDb.setRuolo(giocatoreInput.getRuolo());
		giocatoreDb.setPrezzo(giocatoreInput.getPrezzo());
		return dao.save(giocatoreDb);
	}
	
}
