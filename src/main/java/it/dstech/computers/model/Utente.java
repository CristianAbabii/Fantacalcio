package it.dstech.computers.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.dstech.computers.model.UtenteProfile;

@Entity (name = "utente")
	public class Utente extends Base {

		@Column (name = "username", nullable = false, unique = true)
		private String username;
		@Column (name = "password", nullable = false, unique = true)
		private String password;
		
		@Column (name = "budget", nullable = false, unique = false)
		private Integer budget;
		
		@Enumerated(EnumType.STRING)
		private UtenteProfile profileType;

		@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente")
		@JsonIgnore
		private Squadra squadra;
		
		@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JsonIgnore
		private Campionato campionato;
		
		public Campionato getCampionato() {
			return campionato;
		}

		public void setCampionato(Campionato campionato) {
			this.campionato = campionato;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getBudget() {
			return budget;
		}

		public void setBudget(Integer budget) {
			this.budget = budget;
		}

		public UtenteProfile getProfileType() {
			return profileType;
		}

		public void setProfileType(UtenteProfile profileType) {
			this.profileType = profileType;
		}
		
		public void setSquadra(Squadra s) {
			
			this.squadra = s;
		}
		
		public Squadra getSquadra() {
			
			return this.squadra;
		}
		
	}