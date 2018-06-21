package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Giocatore;
import it.dstech.computers.service.GiocatoreService;



@RestController
@RequestMapping("/giocatore")
public class GiocatoreCtrl {


	@Autowired
	private GiocatoreService serviceGiocatore;

	@RequestMapping (method = RequestMethod.POST, value = "/create")
	public Giocatore create (@RequestBody Giocatore giocatore) {
		return serviceGiocatore.create(giocatore);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/findOne/{id}")
	public Giocatore findOne (@PathVariable Long id) throws Exception {
		return serviceGiocatore.findOne(id);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/findAll")
	public Iterable<Giocatore> findAll() {
		return serviceGiocatore.findAll();
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/deleteOne")
	public void deleteOne (Long id) {
		serviceGiocatore.deleteOne(id);
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "/deleteAll") 
	public void deleteAll() {
		serviceGiocatore.deleteAll();
	}
	@RequestMapping (method = RequestMethod.PUT, value = "/update")
	public Giocatore update (@RequestBody Giocatore giocatoreInput) throws Exception {
		return serviceGiocatore.update(giocatoreInput);
	}
}
