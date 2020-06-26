package it.dstech.formazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.modelli.Persona;

public interface PersonaRepo extends JpaRepository<Persona, String>{


}
