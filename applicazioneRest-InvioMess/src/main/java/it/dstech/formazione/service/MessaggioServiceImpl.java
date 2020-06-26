package it.dstech.formazione.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.dstech.formazione.modelli.Messaggio;
import it.dstech.formazione.modelli.Persona;
import it.dstech.formazione.repository.MessaggioRepo;
import it.dstech.formazione.repository.PersonaRepo;

public class MessaggioServiceImpl implements MessaggioService{

	@Autowired
	private MessaggioRepo messaggioRepo;
	
	@Autowired
	private PersonaRepo personaRepos;
	
	

	@Override
	public void remove(Messaggio m) {
      messaggioRepo.delete(m);	
	}
	
	@Override
	public boolean add(Messaggio m, Persona sender, Persona reciver) {
		m.setUserRecive(reciver);
		m.setUserSend(sender);
		Messaggio mess = messaggioRepo.save(m);
		sender.getListaMessaggi().add(mess);
		reciver.getListaMessaggi().add(mess);
		personaRepos.save(sender);
		personaRepos.save(reciver);


		return false;
	}
}
