package it.dstech.formazione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.modelli.Persona;
import it.dstech.formazione.repository.PersonaRepo;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	
	@Autowired
	private PersonaRepo personaRepos;

	@Override
	public boolean add(Persona t) {
		if (!controlloNickname(t.getNickname())) {
			
			return false;
		}
		 personaRepos.save(t);
		return true;
	}

	@Override
	public List<Persona> findAllPers() {
		return personaRepos.findAll();
	}

	@Override
	public void remove(Persona t) {
		personaRepos.delete(t);
	}
	
	
	
	public boolean controlloNickname(String nickname) {
		List<Persona> lista = findAllPers();
		for(Persona persona:lista) {
			if(persona.getNickname().equalsIgnoreCase(nickname)) {
				return false;
			}
		}
		return true;
	}

	
	
	

	@Override
	public Persona findPers(String nickname) {
		Persona p=personaRepos.findById(nickname).get();
		return p;
	}

	
}
