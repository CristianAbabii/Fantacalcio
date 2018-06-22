package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Campionato;
import it.dstech.computers.model.Squadra;
import it.dstech.computers.service.CampionatoService;

@RestController
@RequestMapping ("/campionato")
public class CampionatoCtrl {

	@Autowired
	private CampionatoService service;
	
	@RequestMapping (method = RequestMethod.GET, value = "/findOne{id}") 
	public Campionato findOne (@PathVariable Long id) throws Exception {
		return service.findOne(id);
	}
	@RequestMapping (method = RequestMethod.POST, value = "/create") 
	public Campionato create (@RequestBody Campionato c) {
		return service.create(c);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/classifica") 
	public Iterable<Squadra> classifica (@RequestParam Campionato c) {
		return service.classifica(c);
	}
}
