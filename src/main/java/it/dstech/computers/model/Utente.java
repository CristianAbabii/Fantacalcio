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
		
	}