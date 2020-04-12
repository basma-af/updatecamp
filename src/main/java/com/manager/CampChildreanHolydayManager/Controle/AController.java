package com.manager.CampChildreanHolydayManager.Controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

import com.manager.CampChildreanHolydayManager.Entites.Equipe;
import com.manager.CampChildreanHolydayManager.Entites.Personne;
import com.manager.CampChildreanHolydayManager.service.EquipeService;
import com.manager.CampChildreanHolydayManager.service.PersonneService;
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
	  @Autowired
	    private EquipeService EQservice;
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  // enregistre new personne
	  @RequestMapping("/Ajouter_equipe")
	  public String showNewEquipePage(Model model) {
		  Equipe equipe = new Equipe();
	      model.addAttribute("equipe", equipe);
	       
	      return "new_equipe";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/saveequipe", method = RequestMethod.POST)
	  public String save(@ModelAttribute("equipe") Equipe equipe) {
	      EQservice.save(equipe);
	       
	      return "redirect:/Ajouter_equipe";
	  }

	   @GetMapping("/Ajouter_equipe")
	    public String viewHomePagee( Model model) {
	   List<Equipe> list =EQservice.getJoinInformation();
	   model.addAttribute("list",list);
	   return "redirect:/Ajouter_equipe";
	    }
	  

	 
}
