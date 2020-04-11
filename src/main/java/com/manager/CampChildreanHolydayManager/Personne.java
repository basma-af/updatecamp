package com.manager.CampChildreanHolydayManager;

import java.lang.String;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "personne")
public class Personne {
	private long id;
	private String CIN;
	private String Nom;
	private String Prenom;
	private String Diplome;
	private String email;
	private int Numero_Tel;
	private String tache;
	private String Genre;
	@Column(name = "username", length = 65)
	private String username;
	@Column(name = "password", length = 64)
	private String password;
	
	protected  Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public Personne(String cIN, String nom, String prenom, String diplome, String email, int numero_Tel, String tache,
			String genre, String username, String password) {
		super();
		CIN = cIN;
		Nom = nom;
		Prenom = prenom;
		Diplome = diplome;
		this.email = email;
		Numero_Tel = numero_Tel;
		this.tache = tache;
		Genre = genre;
		this.username = username;
		this.password = password;
	}




	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getDiplome() {
		return Diplome;
	}
	public void setDiplome(String diplome) {
		Diplome = diplome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumero_Tel() {
		return Numero_Tel;
	}
	public void setNumero_Tel(int numero_Tel) {
		Numero_Tel = numero_Tel;
	}
	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
	}


	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public String getGenre() {
		return Genre;
	}


	public void setGenre(String genre) {
		Genre = genre;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
}
