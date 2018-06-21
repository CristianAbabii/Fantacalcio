package it.dstech.computers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import it.dstech.computers.model.Giocatore;
import it.dstech.computers.model.Ruolo;
import it.dstech.computers.model.Squadra;
import it.dstech.computers.model.Utente;
import it.dstech.computers.repository.ISquadraRepository;

@Service
public class SquadraService {

	@Autowired
	private ISquadraRepository dao;
	@Autowired
	private UtenteService serviceUtente;
	@Autowired
	private GiocatoreService serviceGioc;

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
		Utente utente = serviceUtente.findOne(id);
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

	public Squadra compraGiocatore (Long id, List<Giocatore> rosa) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = serviceUtente.findByUsername(auth.getName());
		Squadra s = utente.getSquadra();
		int por = 0;
		int def = 0;
		int cen = 0;
		int att = 0;
		for (Giocatore g : rosa) {
			if(rosa.size() < 11) {
				Giocatore giocatoreDaComprare = serviceGioc.findOne(id);
				if(por < 1 && giocatoreDaComprare.getRuolo() == Ruolo.PORTIERE ) {
					rosa.add(giocatoreDaComprare);
				}else if(def < 5 && giocatoreDaComprare.getRuolo() == Ruolo.DIFENSORE) {
					rosa.add(giocatoreDaComprare);
				}else if(cen < 5 && giocatoreDaComprare.getRuolo() == Ruolo.CENTROCAMPISTA) {
					rosa.add(giocatoreDaComprare);
				}else if(att < 3 && giocatoreDaComprare.getRuolo() == Ruolo.ATTACCANTE) {
					rosa.add(giocatoreDaComprare);
				}else { throw new Exception ("non puoi comprare gicoatori.");
				}
			} else {throw new Exception ("la rosa è completa");
			}
		}
		return dao.save(rosa);
	}

}

