package it.dstech.formazione.modelli;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Persona {

	
	
	

	
	private String nome;

	private String cognome;

	@Id
	private String nickname;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<Messaggio> listaMessaggi = new ArrayList<Messaggio>();
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Messaggio> getListaMessaggi() {
		return listaMessaggi;
	}

	public void setListaMessaggi(List<Messaggio> listaMessaggi) {
		this.listaMessaggi = listaMessaggi;
	}
	
	
}
