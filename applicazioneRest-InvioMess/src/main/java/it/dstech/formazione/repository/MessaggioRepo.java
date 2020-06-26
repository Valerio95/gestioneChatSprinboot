package it.dstech.formazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.modelli.Messaggio;

public interface MessaggioRepo extends JpaRepository<Messaggio, Long>{

}
