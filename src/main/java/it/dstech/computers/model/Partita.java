package it.dstech.computers.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name = "partita")
public class Partita extends Base {

	@Column (name = "data", nullable = false, unique = false)
	private LocalDate data;
	
	@Column (name = "risultato", nullable = false, unique = false)
	private Integer risultato;
	
	
	private Campionato campionato;
	
	private List<Voto> voti;
	
	private List<Giocatore> giocatori;
	
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getRisultato() {
		return risultato;
	}

	public void setRisultato(Integer risultato) {
		this.risultato = risultato;
	}

	public Campionato getCampionato() {
		return campionato;
	}

	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}

	public List<Voto> getVoti() {
		return voti;
	}

	public void setVoti(List<Voto> voti) {
		this.voti = voti;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

}
