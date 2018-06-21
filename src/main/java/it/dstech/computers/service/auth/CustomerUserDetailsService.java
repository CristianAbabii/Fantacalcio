package it.dstech.computers.service.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.computers.model.Utente;
import it.dstech.computers.service.UtenteService;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	private static final Logger logger = java.util.logging.Logger.getLogger(CustomerUserDetailsService.class.getName());

	@Autowired
	private UtenteService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		Utente utente = userService.findByUsername(username);
		logger.info("User: " + username);
		if (utente == null) {
			logger.info ("User not found");
			throw new UsernameNotFoundException ("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(utente.getUsername(), utente.getPassword(), true, true, true, true, getGrantedAuthorities(utente));
	}
	private List<GrantedAuthority> getGrantedAuthorities(Utente utente) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority ("" + utente.getProfileType()));

		logger.info("Authorities: " + authorities);
		return authorities;
	}
}
