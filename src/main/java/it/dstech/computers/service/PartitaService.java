package it.dstech.computers.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Campionato;
import it.dstech.computers.model.Giocatore;
import it.dstech.computers.model.Partita;
import it.dstech.computers.model.Squadra;
import it.dstech.computers.model.Voto;
import it.dstech.computers.repository.IPartitaRepository;

@Service
public class PartitaService {

	@Autowired
	private IPartitaRepository dao;
	
	@Autowired
	private SquadraService serviceSquadra;
	
	@Autowired
	private GiocatoreService serviceGiocatore;
	
	@Autowired
	private VotoService serviceVoto;
	
	@Autowired
	private CampionatoService serviceCampionato;
	
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
	
	public Partita disputa(Long idSquadraCasa, Long idSquadraTrasferta, List<Voto> votiSquadraCasa, List<Voto> votiSquadraTrasferta) throws Exception {
		
		Squadra casa = serviceSquadra.findOne(idSquadraCasa);
		Squadra trasferta = serviceSquadra.findOne(idSquadraTrasferta);
		
		Campionato c = casa.getCampionato();
		
		Partita p = new Partita();
		p.setCampionato(c);
		
		p.setData(LocalDate.now());
		
		Double punteggioCasa = 0.0;
		for(Voto v : votiSquadraCasa) {
			punteggioCasa += v.getVoto();
		}
		
		Double punteggioTrasferta = 0.0;
		for(Voto v : votiSquadraTrasferta) {
			punteggioTrasferta += v.getVoto();
		}
		
		double differenza = punteggioCasa - punteggioTrasferta;
		p.setRisultato((int) differenza);
		
		List<Voto> votiTotali = new ArrayList<>();
		votiTotali.addAll(votiSquadraCasa);
		votiTotali.addAll(votiSquadraTrasferta);
		p.setVoti(votiTotali);
		
		List<Giocatore> giocatoriTotali = new ArrayList<>();
		giocatoriTotali.addAll(casa.getRosa());
		giocatoriTotali.addAll(trasferta.getRosa());
		p.setGiocatori(giocatoriTotali);
		
		for(Giocatore g : casa.getRosa()) {
			List<Partita> listaPartite = g.getListaPartite();
			if(listaPartite == null) listaPartite = new ArrayList<>();
			listaPartite.add(p);
			serviceGiocatore.update(g);
		}
		
		for(Voto v : votiTotali) {
			List<Partita> listaPartite = v.getPartite();
			if(listaPartite == null) listaPartite = new ArrayList<>();
			listaPartite.add(p);
			serviceVoto.update(v);
		}
		
		List<Partita> listaPartite = c.getPartite();
		if(listaPartite == null) listaPartite = new ArrayList<>();
		listaPartite.add(p);
		c.setPartite(listaPartite);
		serviceCampionato.update(c);
		
		return create(p);
	}
	 
}
