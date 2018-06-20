package it.dstech.computers.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Squadra extends Base {
	
	@Column(name = "nome", nullable = false, unique = true)
	private String nome;
	
	//OneToOne
	private Utente utente;
	
	//ManyToOne
	private Campionato campionato;
	
	//OneToMany
	private List<Giocatore> rosa;
	
	@Column(name = "punti")
	private Integer punti;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}

	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	/**
	 * @return the campionato
	 */
	public Campionato getCampionato() {
		return campionato;
	}

	/**
	 * @param campionato the campionato to set
	 */
	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}

	/**
	 * @return the rosa
	 */
	public List<Giocatore> getRosa() {
		return rosa;
	}

	/**
	 * @param rosa the rosa to set
	 */
	public void setRosa(List<Giocatore> rosa) {
		this.rosa = rosa;
	}

	/**
	 * @return the punti
	 */
	public Integer getPunti() {
		return punti;
	}

	/**
	 * @param punti the punti to set
	 */
	public void setPunti(Integer punti) {
		this.punti = punti;
	}

}
