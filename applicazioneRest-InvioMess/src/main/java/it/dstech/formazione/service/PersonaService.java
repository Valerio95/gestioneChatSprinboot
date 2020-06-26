package it.dstech.formazione.service;

import java.util.List;

import it.dstech.formazione.modelli.Persona;

public interface PersonaService {
	
	


	
	boolean add(Persona t);

	List<Persona > findAllPers();

	void remove(Persona t);

	Persona findPers(String nickname); 
		
	
}
