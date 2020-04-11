package com.manager.CampChildreanHolydayManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipe {
	private Long id;
	private String  Nom_Moniteur;
	private String Nom_Benificier;
	private String Nom_Equipe;
	
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipe(String nom_Moniteur, String nom_Benificier, String nom_Equipe) {
		super();
		Nom_Moniteur = nom_Moniteur;
		Nom_Benificier = nom_Benificier;
		Nom_Equipe = nom_Equipe;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_Moniteur() {
		return Nom_Moniteur;
	}

	public void setNom_Moniteur(String nom_Moniteur) {
		Nom_Moniteur = nom_Moniteur;
	}

	public String getNom_Benificier() {
		return Nom_Benificier;
	}

	public void setNom_Benificier(String nom_Benificier) {
		Nom_Benificier = nom_Benificier;
	}

	public String getNom_Equipe() {
		return Nom_Equipe;
	}

	public void setNom_Equipe(String nom_Equipe) {
		Nom_Equipe = nom_Equipe;
	}
	
	
	

}
