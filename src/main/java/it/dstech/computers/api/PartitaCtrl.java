package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Partita;
import it.dstech.computers.service.auth.PartitaService;

@RestController
@RequestMapping ("/partita")
public class PartitaCtrl {

	@Autowired
	private PartitaService servicePartita;

	@RequestMapping (method = RequestMethod.POST, value = "/create")
	public Partita create (@RequestBody Partita partita) {
		return servicePartita.create(partita);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/findOne/{id}")
	public Partita findOne (@PathVariable Long id) throws Exception {
		return servicePartita.findOne(id);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/findAll")
	public Iterable<Partita> findAll() {
		return servicePartita.findAll();
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/deleteOne")
	public void deleteOne (Long id) {
		servicePartita.deleteOne(id);
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/deleteAll") 
	public void deleteAll() {
		servicePartita.deleteAll();
	}
	@RequestMapping (method = RequestMethod.PUT, value = "/update")
	public Partita update (@RequestBody Partita partitaInput) throws Exception {
		return servicePartita.update(partitaInput);
	}
}

