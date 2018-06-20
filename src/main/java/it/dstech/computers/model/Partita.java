package it.dstech.computers.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "partita")
public class Partita extends Base {

	@Column (name = "data", nullable = false, unique = false)
	private LocalDate data;
	
	@Column (name = "risultato", nullable = false, unique = false)
	private Integer risultato;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Campionato campionato;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "partite_voti", joinColumns = {
			@JoinColumn(name = "partita_id", nullable = false, updatable = true)
	}, inverseJoinColumns = {
			@JoinColumn(name = "voto_id", nullable = false, updatable = true)
	})
	@JsonIgnore
	private List<Voto> voti;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "partite_giocatori", joinColumns = {
			@JoinColumn(name = "partita_id", nullable = false, updatable = true)
	}, inverseJoinColumns = {
			@JoinColumn(name = "giocatore_id", nullable = false, updatable = true)
	})
	@JsonIgnore
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
