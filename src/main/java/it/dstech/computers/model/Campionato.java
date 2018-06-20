package it.dstech.computers.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name = "campionato")
public class Campionato extends Base {
	
	@Column (name = "nome", nullable = false, unique = true)
	private String nome;
	
	@Column (name = "giornate", nullable = false, unique = false)
	private Integer giornate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campionato")
	@JsonIgnore
	private List<Utente> utenti;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campionato")
	@JsonIgnore
	private List<Squadra> squadre;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "campionato")
	@JsonIgnore
	private List<Partita> partite;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getGiornate() {
		return giornate;
	}

	public void setGiornate(Integer giornate) {
		this.giornate = giornate;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public List<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
	}

	public List<Partita> getPartite() {
		return partite;
	}

	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}


}
