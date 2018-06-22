package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Utente;
import it.dstech.computers.service.UtenteService;
import it.dstech.computers.service.auth.AuthService;

@RestController
@RequestMapping ("/utente")
public class UtenteCtrl {
	
	@Autowired
	private UtenteService service;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthService authService;

	@RequestMapping (method = RequestMethod.GET, value = "/findByUsername{username}")
	public  Utente findByUsername (@PathVariable ("username") String username) {
		return service.findByUsername(username);
	}
	@PostMapping("/login")
	public UserDetails authenticate(@RequestBody Utente utente) throws Exception {
		return authService.authenticate(utente);
	}
	@PostMapping("/register")
	public Utente addUser (@RequestBody Utente utente) {
		utente.setPassword(encoder.encode(utente.getPassword()));
		return service.create(utente);
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/deleteOne")
	public void deleteOne (Long id) {
		service.deleteOne(id);
	}
	@RequestMapping (method = RequestMethod.PUT, value = "update")
	public Utente update (@RequestBody Utente utenteInput) throws Exception {
		return service.update(utenteInput);
	}
}
