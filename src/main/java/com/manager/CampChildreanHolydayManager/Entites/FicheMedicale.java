package com.manager.CampChildreanHolydayManager.Entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Entity
public class FicheMedicale {
	private long id;
	private String cas;
	private String Nom_Respensable_Medicale;
	private String Nom_benificier;
	private String Prenom_benificier;
	private String Moniteur;
	private String Equipe;
	private String Decription;
	private Date date;
	
	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.addDialect(new Java8TimeDialect());
	    engine.setTemplateResolver(templateResolver);
	    return engine;
	}
	
	public  FicheMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FicheMedicale(String cas, String nom_Respensable_Medicale, String nom_benificier, String prenom_benificier,
			String moniteur, String equipe, String decription, Date date) {
		super();
		this.cas = cas;
		Nom_Respensable_Medicale = nom_Respensable_Medicale;
		Nom_benificier = nom_benificier;
		Prenom_benificier = prenom_benificier;
		Moniteur = moniteur;
		Equipe = equipe;
		Decription = decription;
		this.date = date;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getNom_Respensable_Medicale() {
		return Nom_Respensable_Medicale;
	}

	public void setNom_Respensable_Medicale(String nom_Respensable_Medicale) {
		Nom_Respensable_Medicale = nom_Respensable_Medicale;
	}

	public String getNom_benificier() {
		return Nom_benificier;
	}

	public void setNom_benificier(String nom_benificier) {
		Nom_benificier = nom_benificier;
	}

	public String getPrenom_benificier() {
		return Prenom_benificier;
	}

	public void setPrenom_benificier(String prenom_benificier) {
		Prenom_benificier = prenom_benificier;
	}

	public String getMoniteur() {
		return Moniteur;
	}

	public void setMoniteur(String moniteur) {
		Moniteur = moniteur;
	}

	public String getEquipe() {
		return Equipe;
	}

	public void setEquipe(String equipe) {
		Equipe = equipe;
	}

	public String getDecription() {
		return Decription;
	}

	public void setDecription(String decription) {
		Decription = decription;
	}




}
