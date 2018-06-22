package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Partita;
import it.dstech.computers.repository.IPartitaRepository;

@Service
public class PartitaService {

	@Autowired
	private IPartitaRepository dao;
	
	public Partita create (Partita partita) {
		return dao.save(partita);
	}
	public Partita findOne (Long id) throws Exception {
		return dao.findById(id).orElseThrow(()-> new Exception());
	}
	public Iterable<Partita> findAll() {
		return dao.findAll();
	}
	public void deleteOne(Long id) {
		dao.deleteById(id);
	}
	public void deleteAll() {
		dao.deleteAll();
	}
	public Partita update (Partita partitaInput) throws Exception {
		Partita partitaDb = findOne (partitaInput.getId());
		partitaDb.setCampionato(partitaInput.getCampionato());
		partitaDb.setData(partitaInput.getData());
		partitaDb.setRisultato(partitaInput.getRisultato());
		return dao.save(partitaDb);
	}
	 
}
