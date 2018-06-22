package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Voto;
import it.dstech.computers.service.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoCtrl {

	@Autowired
	private VotoService service;
	
	@RequestMapping (method = RequestMethod.POST, value = "/create")
	public Voto create (@RequestBody Voto v) {
		return service.create(v);
	}
	
}
