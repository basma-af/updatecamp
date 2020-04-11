package com.manager.CampChildreanHolydayManager;

import java.io.PrintWriter;
import java.util.List;

public class ExcelMoniteur {
	  public static void downloadCsvMoniteur(PrintWriter writer, List<Moniteur> Moniteurs) {
			 
			 
	        writer.write("Moniteur ID , Nom, Prenom, CIN, Diplome , Email,Numero_tel,Genre, Tache \n");
	        for (Moniteur Moniteur : Moniteurs) {writer.write(Moniteur.getId() + "," + Moniteur.getNom() + "," + Moniteur.getPrenom() + ","+Moniteur.getCIN() + ","+Moniteur.getDiplome() + ","+Moniteur.getEmail() + ","+Moniteur.getNumero_Tel() + ","+Moniteur.getGenre() + ","+Moniteur.getTache() + "\n");
	        }
	      
	    }	
}
