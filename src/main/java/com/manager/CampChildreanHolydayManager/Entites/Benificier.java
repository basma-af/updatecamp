package com.manager.CampChildreanHolydayManager.Entites;


import javax.persistence.*;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Benificier {
	private long id;
	private String Nom;
	private String Prenom;
	private String Date_Naissance;
	private String Tuteur_Nom_Complet;
	private String CIN;
	private String Email;
	private String Addresse;
	private int Numero_Tel;
	private String Profession;
	private String Moniteur;
	private String Genre;
	private String Lieu;
	
	public  Benificier() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Benificier(String nom, String prenom, String date_Naissance, String tuteur_Nom_Complet, String cIN,
			String email, String addresse, int numero_Tel, String profession, String moniteur, String genre,
			String lieu) {
		super();
		Nom = nom;
		Prenom = prenom;
		Date_Naissance = date_Naissance;
		Tuteur_Nom_Complet = tuteur_Nom_Complet;
		CIN = cIN;
		Email = email;
		Addresse = addresse;
		Numero_Tel = numero_Tel;
		Profession = profession;
		Moniteur = moniteur;
		Genre = genre;
		Lieu = lieu;
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

	public String getDate_Naissance() {
		return Date_Naissance;
	}

	public void setDate_Naissance(String date_Naissance) {
		Date_Naissance = date_Naissance;
	}

	public String getTuteur_Nom_Complet() {
		return Tuteur_Nom_Complet;
	}

	public void setTuteur_Nom_Complet(String tuteur_Nom_Complet) {
		Tuteur_Nom_Complet = tuteur_Nom_Complet;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddresse() {
		return Addresse;
	}

	public void setAddresse(String addresse) {
		Addresse = addresse;
	}

	public int getNumero_Tel() {
		return Numero_Tel;
	}

	public void setNumero_Tel(int numero_Tel) {
		Numero_Tel = numero_Tel;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public String getMoniteur() {
		return Moniteur;
	}

	public void setMoniteur(String moniteur) {
		Moniteur = moniteur;
	}



	public String getGenre() {
		return Genre;
	}



	public void setGenre(String genre) {
		Genre = genre;
	}



	public String getLieu() {
		return Lieu;
	}



	public void setLieu(String lieu) {
		Lieu = lieu;
	}
	
	
}
