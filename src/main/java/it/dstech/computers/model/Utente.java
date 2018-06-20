package it.dstech.computers.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import it.dstech.computers.model.UtenteProfile;

@Entity (name = "utente")
	public class Utente extends Base {

		@Column (name = "username", nullable = false, unique = true)
		private String username;
		@Column (name = "password", nullable = false, unique = true)
		private String password;
		
		@Column (name = "budget", nullable = false, unique = false)
		private Integer budget;
		
		private UtenteProfile profileType;
		
	}