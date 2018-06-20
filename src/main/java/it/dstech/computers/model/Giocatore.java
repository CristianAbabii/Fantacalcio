package it.dstech.computers.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "giocatore")
public class Giocatore extends Base {

	@Column (name = "nome", nullable = false, unique = false)
	private String nome;
	@Column (name = "cognome", nullable = false, unique = false)
	private String cognome;
	@Column (name = "squadraReale", nullable = false, unique = false)
	private String squadraReale;
	
	@Enumerated (EnumType.STRING)
	private Ruolo ruolo;
	@Column (name = "prezzo", nullable = false, unique = false)
	private Integer prezzo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Squadra squadra;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "giocatori")
	@JsonIgnore
	private List<Partita> listaPartite;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSquadraReale() {
		return squadraReale;
	}

	public void setSquadraReale(String squadraReale) {
		this.squadraReale = squadraReale;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public List<Partita> getListaPartite() {
		return listaPartite;
	}

	public void setListaPartite(List<Partita> listaPartite) {
		this.listaPartite = listaPartite;
	}
	
	
	
}
