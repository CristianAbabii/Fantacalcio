package it.dstech.computers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Campionato;
import it.dstech.computers.model.Squadra;
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
	
	public Iterable<Squadra> classifica(Campionato c) {
		
		List<Squadra> listaSquadre = c.getSquadre();
				
		Squadra temp = new Squadra();
		
		for(int i = 0; i < listaSquadre.size(); i ++) {
			for(int j = 0; j < listaSquadre.size(); j++) {
				if(listaSquadre.get(i).getPunti() < listaSquadre.get(j).getPunti()) {
					Squadra due = listaSquadre.get(j);
					temp = listaSquadre.get(i);
					listaSquadre.add(i, due);
					listaSquadre.add(j, temp);
				}
			}
		}
		
		
		return listaSquadre;

	}

}
