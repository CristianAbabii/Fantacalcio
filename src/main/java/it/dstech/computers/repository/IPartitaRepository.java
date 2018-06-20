package it.dstech.computers.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.computers.model.Partita;

public interface IPartitaRepository extends CrudRepository<Partita, Long> {

}
