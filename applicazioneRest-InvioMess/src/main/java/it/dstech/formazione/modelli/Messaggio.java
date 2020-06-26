package it.dstech.formazione.modelli;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Messaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="userSand")
	private Persona userSend;
	
	@ManyToOne
	@JoinColumn(name="userRecive")
	private Persona userRecive;

	private String messaggio;
	
	@CreationTimestamp
    private Timestamp data;

	

	public Persona getUserSend() {
		return userSend;
	}

	public void setUserSend(Persona userSend) {
		this.userSend = userSend;
	}

	public Persona getUserRecive() {
		return userRecive;
	}

	public void setUserRecive(Persona userRecive) {
		this.userRecive = userRecive;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
