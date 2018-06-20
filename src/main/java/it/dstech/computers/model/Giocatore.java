package it.dstech.computers.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity (name = "giocatore")
public class Giocatore {

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
	@Column (name = "squadra", nullable = false, unique = false)
	private Squadra squadra;
	
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
