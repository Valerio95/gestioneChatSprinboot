package it.dstech.formazione.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.formazione.modelli.Messaggio;
import it.dstech.formazione.modelli.Persona;
import it.dstech.formazione.service.MessaggioService;
import it.dstech.formazione.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private MessaggioService messaggioService;
	
	@Autowired
	private PersonaService personaService;

	@RequestMapping("/allUsernames")
	public List<Persona> getAllPeople() {
		return personaService.findAllPers();
	}
	
	@RequestMapping(value = ("/addPersona"), method = RequestMethod.POST)
	public boolean addNewPersona(@RequestBody Persona persona) {
		return personaService.add(persona);
	}
	
	@RequestMapping(value = ("/deletePersona"), method = RequestMethod.DELETE)
	public void removePersona(@RequestBody Persona persona) {
		personaService.remove(persona);
		
	}
	
	@RequestMapping(value = ("/cercaPersona"), method = RequestMethod.GET)
	public Persona cercaPersona(@RequestBody String username) {
		
		return personaService.findPers(username);
		
	}
	
	@RequestMapping(value = ("/inviaMess"), method = RequestMethod.POST)
	public void inviaMess(@RequestBody Messaggio messaggio) {
		Persona sender = personaService.findPers(messaggio.getUserSend().getNickname());
		Persona reciver = personaService.findPers(messaggio.getUserRecive().getNickname());

		messaggioService.add(messaggio, sender, reciver);
		
	}
	
	@RequestMapping(value = ("/getAllMess"), method = RequestMethod.POST)
	public List<Messaggio> getAllMess(@RequestBody String nickname) {
		Persona persona = personaService.findPers(nickname);

		
		return persona.getListaMessaggi();
		
	}
	
	@RequestMapping(value = ("/getMessInviati"), method = RequestMethod.GET)
	public List<Messaggio> getAllMessInviati(@RequestBody String nickname) {
		Persona persona = personaService.findPers(nickname);
         List<Messaggio> messInviati = new ArrayList<Messaggio>();
         
         for(Messaggio mess:persona.getListaMessaggi()) {
        	 if(mess.getUserSend().getNickname().equalsIgnoreCase(nickname)) {
        		 messInviati.add(mess);
        	 }
         }
		
		return messInviati;
		
	}
	
	@RequestMapping(value = ("/getMessRicevuti"), method = RequestMethod.GET)
	public List<Messaggio> getAllMessRicevuti(@RequestBody String nickname) {
		Persona persona = personaService.findPers(nickname);
         List<Messaggio> messRicevuti = new ArrayList<Messaggio>();
         
         for(Messaggio mess:persona.getListaMessaggi()) {
        	 if(!mess.getUserSend().getNickname().equalsIgnoreCase(nickname)) {
        		 messRicevuti.add(mess);
        	 }
         }
		
		return messRicevuti;
		
	}
	
	@RequestMapping(value = ("/getOneChat"), method = RequestMethod.GET)
	public List<Messaggio> getOneChat(@RequestBody String utente, String altroUtente ) {
		Persona persona = personaService.findPers(utente);
         List<Messaggio> chat = new ArrayList<Messaggio>();
         
         for(Messaggio mess:persona.getListaMessaggi()) {
        	 if(mess.getUserSend().getNickname().equalsIgnoreCase(altroUtente)||mess.getUserRecive().getNickname().equalsIgnoreCase(altroUtente) ) {
        		 chat.add(mess);
        	 }
         }
		
		return chat;
		
	}
	
}
