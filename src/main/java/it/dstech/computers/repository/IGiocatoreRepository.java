package it.dstech.computers.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.computers.model.Giocatore;

public interface IGiocatoreRepository extends CrudRepository<Giocatore, Long>{
	

}
