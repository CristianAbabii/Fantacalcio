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

	public Squadra compraGiocatore (Long idGiocatoreDaComprare) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = serviceUtente.findByUsername(auth.getName());
		
		Giocatore gdc = serviceGioc.findOne(idGiocatoreDaComprare);
		// if gdc == null throw exception
		
		if(gdc.getPrezzo() > utente.getBudget()) {
			return null;
			// throw new Exception ....
		}
		
		Squadra s = utente.getSquadra();
		List<Giocatore> rosa = s.getRosa();
		int por = 0;
		int def = 0;
		int cen = 0;
		int att = 0;
		if(rosa.size() < 11) {
			for (Giocatore g : rosa) {
				if(g.getRuolo() == Ruolo.PORTIERE) {
					por++;
				}
				if(g.getRuolo() == Ruolo.DIFENSORE) {
					def++;
				}
				if(g.getRuolo() == Ruolo.CENTROCAMPISTA) {
					cen++;
				}
				if(g.getRuolo() == Ruolo.ATTACCANTE) {
					att++;
				}
				
			}
		} else { 
			throw new Exception ("la rosa è completa");
		}
		
		if(por < 1 && gdc.getRuolo() == Ruolo.PORTIERE) {
			rosa.add(gdc);
			gdc.setSquadra(s);
		}
		if(def < 5 && gdc.getRuolo() == Ruolo.DIFENSORE) {
			rosa.add(gdc);
			gdc.setSquadra(s);
		}
		if(cen < 5 && gdc.getRuolo() == Ruolo.CENTROCAMPISTA) {
			rosa.add(gdc);
			gdc.setSquadra(s);
		}
		if(att < 3 && gdc.getRuolo() == Ruolo.ATTACCANTE) {
			rosa.add(gdc);
			gdc.setSquadra(s);
		}
		
		s.setRosa(rosa);

		utente.setBudget(utente.getBudget() - gdc.getPrezzo());
		serviceUtente.update(utente);
		
		serviceGioc.update(gdc);
		
		return dao.save(s);
	}
	
	public Squadra vendi(Long idGiocatore) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente u = serviceUtente.findByUsername(auth.getName());
		
		Giocatore gdv = serviceGioc.findOne(idGiocatore);
		
		Squadra s = gdv.getSquadra();
		if(s == null) {
			return null;
			//throw new Exception("Giocatore non ha nessuna squadra");
		}
		
		List<Giocatore> rosa = s.getRosa();
		rosa.remove(gdv);
		gdv.setSquadra(null);
		s.setRosa(rosa);
		
		u.setBudget(u.getBudget() + gdv.getPrezzo());
		
		serviceUtente.update(u);
		serviceGioc.update(gdv);
		
		return dao.save(s);
	}

}