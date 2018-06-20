package it.dstech.computers.repository;


	import org.springframework.data.repository.CrudRepository;

	import it.dstech.computers.model.Utente;

	public interface IUtenteRepository extends CrudRepository<Utente, Long>{ 
		
	  Utente findByUsername(String username);
	}

