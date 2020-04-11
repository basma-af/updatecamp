package com.manager.CampChildreanHolydayManager;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgrammeAlimentaire {
	private long id;
	private String Nom_Respensable;
	private Date date;
	private int Jour;
	private String Petit_Dejeuner;
	private String Dejeuner;
	private String Collation;
	private String Diner;
	private String Facture;
	private String Remarque;
	
	protected ProgrammeAlimentaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProgrammeAlimentaire(String nom_Respensable, Date date, int jour, String petit_Dejeuner, String dejeuner,
			String collation, String diner, String facture, String remarque) {
		super();
		Nom_Respensable = nom_Respensable;
		this.date = date;
		Jour = jour;
		Petit_Dejeuner = petit_Dejeuner;
		Dejeuner = dejeuner;
		Collation = collation;
		Diner = diner;
		Facture = facture;
		Remarque = remarque;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom_Respensable() {
		return Nom_Respensable;
	}

	public void setNom_Respensable(String nom_Respensable) {
		Nom_Respensable = nom_Respensable;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getJour() {
		return Jour;
	}

	public void setJour(int jour) {
		Jour = jour;
	}

	public String getPetit_Dejeuner() {
		return Petit_Dejeuner;
	}

	public void setPetit_Dejeuner(String petit_Dejeuner) {
		Petit_Dejeuner = petit_Dejeuner;
	}

	public String getDejeuner() {
		return Dejeuner;
	}

	public void setDejeuner(String dejeuner) {
		Dejeuner = dejeuner;
	}

	public String getCollation() {
		return Collation;
	}

	public void setCollation(String collation) {
		Collation = collation;
	}

	public String getDiner() {
		return Diner;
	}

	public void setDiner(String diner) {
		Diner = diner;
	}

	public String getFacture() {
		return Facture;
	}

	public void setFacture(String facture) {
		Facture = facture;
	}


	public String getRemarque() {
		return Remarque;
	}


	public void setRemarque(String remarque) {
		Remarque = remarque;
	}
	
	

}
