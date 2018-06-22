package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Campionato;
import it.dstech.computers.repository.ICampionatoRepository;

@Service
public class CampionatoService {
	
	@Autowired
	private ICampionatoRepository dao;
	
	public Iterable<Campionato> findAll() {
		
		return dao.findAll();
	}
	
	public Campionato findOne (Long id ) throws Exception {
		
		return dao.findById(id).orElseThrow(()-> new Exception() );
	}
	
	public void deleteAll() {
		
		dao.deleteAll();
	}
	
	public void deleteOne(Long id) {
		
		dao.deleteById(id);
	}
	
	public Campionato create(Campionato c) {
		
		return dao.save(c);
	}
	
	public Campionato update(Campionato c) throws Exception {
		
		Campionato old = findOne(c.getId());
		
		old.setNome(c.getNome());
		old.setGiornate(c.getGiornate());
		old.setPartite(c.getPartite());
		old.setSquadre(c.getSquadre());
		old.setUtenti(c.getUtenti());
		
		return old;
	}

}
