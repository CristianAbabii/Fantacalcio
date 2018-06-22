package it.dstech.computers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.computers.model.Squadra;
import it.dstech.computers.service.SquadraService;

@RestController
@RequestMapping ("/squadra")
public class SquadraCtrl {

	@Autowired
	private SquadraService service;
	
	@RequestMapping (method = RequestMethod.GET, value = "/findOne{id}")
	public Squadra findOne (@PathVariable Long id) throws Exception {
		return service.findOne(id);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/findAll")
	public Iterable<Squadra> findAll() {
		return service.findAll();
	}
	@RequestMapping (method = RequestMethod.POST, value = "/create")
	public Squadra create (@RequestBody Squadra s, @RequestBody Long id) throws Exception {
		return service.create(s, id);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/compraGiocatore{id}")
	public Squadra compraGiocatore (@PathVariable Long idGiocatoreDaComprare) throws Exception {
		return service.compraGiocatore(idGiocatoreDaComprare);
	}
	@RequestMapping (method = RequestMethod.GET, value = "/vendi{id}")
	public Squadra vendi (@PathVariable Long idGiocatore) throws Exception {
		return service.vendi(idGiocatore);
	}

}
