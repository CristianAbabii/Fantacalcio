package it.dstech.computers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.computers.model.Giocatore;
import it.dstech.computers.model.Squadra;

public interface ISquadraRepository extends CrudRepository<Squadra, Long>{

	Squadra save(List<Giocatore> rosa);

}
