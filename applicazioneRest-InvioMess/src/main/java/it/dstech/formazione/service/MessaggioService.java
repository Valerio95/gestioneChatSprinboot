package it.dstech.formazione.service;

import it.dstech.formazione.modelli.Messaggio;
import it.dstech.formazione.modelli.Persona;

public interface MessaggioService {

	
	boolean add(Messaggio m,Persona sender,Persona reciver);
	
	
	
	void remove(Messaggio m);
}
