package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Voto;
import it.dstech.computers.repository.IVotoRepository;

@Service
public class VotoService {
	
	@Autowired
	private IVotoRepository dao;
	
	
	public Iterable<Voto> findAll() {
		
		return dao.findAll();
	}
	
	public Voto findOne(Long id) throws Exception {
		
		return dao.findById(id).orElseThrow(() -> new Exception());
	}
	
	public void deleteAll() {
		
		dao.deleteAll();
	}
	
	public void deleteOne(Long id) {
		
		dao.deleteById(id);
	}
	
	public Voto create(Voto v) {
		
		return dao.save(v);
	}
	
	public Voto update(Voto v) throws Exception {
		
		Voto old = findOne(v.getId());
		old.setVoto(v.getVoto());
		old.setPartite(v.getPartite());
		return dao.save(old);
	}

}
