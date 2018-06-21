package it.dstech.computers.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import it.dstech.computers.model.Utente;



@Service
public class AuthService {

	@Autowired
	private AuthenticationManager autenthicationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Authentication e user
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public UserDetails authenticate (Utente utente) throws Exception {
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(utente.getUsername());

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loadUserByUsername.getUsername(), utente.getPassword());


		Authentication authentication = autenthicationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return loadUserByUsername;
	}
}

