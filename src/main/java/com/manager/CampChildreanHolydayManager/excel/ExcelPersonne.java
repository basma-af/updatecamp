package com.manager.CampChildreanHolydayManager.excel;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.manager.CampChildreanHolydayManager.Entites.Personne;

public class ExcelPersonne {


	  public static void downloadCsv(PrintWriter writer, List<Personne> personnes) {
		 
		 
	        writer.write("Personne ID, Nom, Prenom, CIN, Diplome,Email,Numero_tel,Genre, Tache \n");
	        for (Personne personne : personnes) {writer.write(personne.getId() + "," + personne.getNom() + "," + personne.getPrenom() + ","+personne.getCIN() + ","+personne.getDiplome() + ","+personne.getEmail() + ","+personne.getNumero_Tel() + ","+personne.getGenre() + ","+personne.getTache() + "\n");
	        }
	      
	    }	       
}
