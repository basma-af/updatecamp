package com.manager.CampChildreanHolydayManager.Entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Equipe implements Serializable{
   
	
	private String  Nom_Moniteur;
	private String Nom_Benificier;
	private String Nom_Equipe;
	private Moniteur moniteur;
	private Benificier benificier;
	 
	 
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Equipe(String nom_Moniteur, String nom_Benificier, String nom_Equipe, Moniteur moniteur,
			Benificier benificier) {
		super();
		Nom_Moniteur = nom_Moniteur;
		Nom_Benificier = nom_Benificier;
		Nom_Equipe = nom_Equipe;
		this.moniteur = moniteur;
		this.benificier = benificier;
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

	@Id
    @ManyToOne
  
	public Moniteur getMoniteur() {
		return moniteur;
	}


	public void setMoniteur(Moniteur moniteur) {
		this.moniteur = moniteur;
	}


    @Id
    @ManyToOne
    
	public Benificier getBenificier() {
		return benificier;
	}


	public void setBenificier(Benificier benificier) {
		this.benificier = benificier;
	}

	
	

}