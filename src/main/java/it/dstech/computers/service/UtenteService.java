package it.dstech.computers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.dstech.computers.model.Utente;
import it.dstech.computers.repository.IUtenteRepository;

@Service
public class UtenteService {


	@Autowired
	private IUtenteRepository dao;

	public Utente create (Utente utente) {
		return dao.save(utente);
	}
	public Iterable<Utente> createList (Iterable<Utente> listaUtente){
		return dao.saveAll(listaUtente);
	}
	public Iterable<Utente> findAll() {
		return dao.findAll();
	}
	public Utente findOne(Long id) throws Exception {
		return dao.findById(id).orElseThrow(()-> new Exception());
	}
	public void deleteAll() {
		dao.deleteAll();
	}
	public void deleteOne(Long id) {
		dao.deleteById(id);
	}
	public Utente update (Utente utenteInput) throws Exception {
		Utente utenteDb = findOne(utenteInput.getId());
		utenteDb.setUsername(utenteInput.getUsername());
		utenteDb.setPassword(utenteInput.getPassword());
		return dao.save(utenteDb);
	}
	public Utente findByUsername (String username) {
		return dao.findByUsername(username);

	}
}
