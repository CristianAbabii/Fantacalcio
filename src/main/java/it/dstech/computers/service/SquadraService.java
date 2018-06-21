package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.dstech.computers.model.Squadra;
import it.dstech.computers.model.Utente;
import it.dstech.computers.repository.ISquadraRepository;

@Service
public class SquadraService {
	
	@Autowired
	private ISquadraRepository dao;
	@Autowired
	private UtenteService service;

	public Iterable<Squadra> findAll() {
		
		return dao.findAll();
	}
	
	public Squadra findOne(Long id) throws Exception {
		
		return dao.findById(id).orElseThrow(() -> new Exception());
	}
	
	public void deleteAll() {
		
		dao.deleteAll();
	}
	
	public void deleteOne(Long id) {
		
		dao.deleteById(id);
	}
	
	public Squadra create(Squadra s, Long id) throws Exception {
		Utente utente = service.findOne(id);
		s.setUtente(utente);
		return dao.save(s);
	}
	
	public Squadra update(Squadra s) throws Exception {
		
		Squadra old = findOne(s.getId());
		
		old.setCampionato(s.getCampionato());
		old.setNome(s.getNome());
		old.setPunti(s.getPunti());
		old.setRosa(s.getRosa());
		old.setUtente(s.getUtente());
		
		return dao.save(old);
	}
}
