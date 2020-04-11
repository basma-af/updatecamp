package com.manager.CampChildreanHolydayManager.Entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activite {
	private long id;
	private String Type_Activite;
	private String Nom_Activite;
	private String Outils;
	private int Nombre_Participants;
	private String Objectif;
    private String Categorie_Cible;
    private String Description;
	
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activite(String type_Activite, String nom_Activite, String outils, int nombre_Participants, String objectif,
			String description, String categorie_Cible) {
		super();
		Type_Activite = type_Activite;
		Nom_Activite = nom_Activite;
		Outils = outils;
		Nombre_Participants = nombre_Participants;
		Objectif = objectif;
		Description = description;
		Categorie_Cible = categorie_Cible;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType_Activite() {
		return Type_Activite;
	}

	public void setType_Activite(String type_Activite) {
		Type_Activite = type_Activite;
	}

	public String getNom_Activite() {
		return Nom_Activite;
	}

	public void setNom_Activite(String nom_Activite) {
		Nom_Activite = nom_Activite;
	}

	public String getOutils() {
		return Outils;
	}

	public void setOutils(String outils) {
		Outils = outils;
	}

	public int getNombre_Participants() {
		return Nombre_Participants;
	}

	public void setNombre_Participants(int nombre_Participants) {
		Nombre_Participants = nombre_Participants;
	}

	public String getObjectif() {
		return Objectif;
	}

	public void setObjectif(String objectif) {
		Objectif = objectif;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategorie_Cible() {
		return Categorie_Cible;
	}

	public void setCategorie_Cible(String categorie_Cible) {
		Categorie_Cible = categorie_Cible;
	}
	
	
}
