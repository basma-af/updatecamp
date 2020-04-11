package com.manager.CampChildreanHolydayManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AController {
	

	  @RequestMapping( "/")
	  String indexAccueil(){ 
		 return "Accueil.html"; }
	  
	  
	  @RequestMapping("/P-Fixe") 
	  String indexProgrammeFixe(){ 
		  return "P-Fixe"; }
	  
	  @RequestMapping("/P-Pedaogique") 
	  String indexProgrammePedaogique(){
		  return "P-Pedaogique"; }
	  
	  @RequestMapping("/p-General") 
	  String indexProgrammeGeneral(){ 
		  return  "p-General"; }
	  
	  @RequestMapping("/connexion") 
	  String indexConnexion(){
		  return "connexion"; }
	 
		  ////////////Equipe//////////////
	
}
