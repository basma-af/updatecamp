package com.manager.CampChildreanHolydayManager.Controle;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.CampChildreanHolydayManager.Entites.Activite;
import com.manager.CampChildreanHolydayManager.Entites.AssistantMedical;
import com.manager.CampChildreanHolydayManager.Entites.Benificier;
import com.manager.CampChildreanHolydayManager.Entites.Economiste;
import com.manager.CampChildreanHolydayManager.Entites.FicheMedicale;
import com.manager.CampChildreanHolydayManager.Entites.Moniteur;
import com.manager.CampChildreanHolydayManager.Entites.Personne;
import com.manager.CampChildreanHolydayManager.dao.ProgrammeAlimentaire;
import com.manager.CampChildreanHolydayManager.service.ActiviteService;
import com.manager.CampChildreanHolydayManager.service.AssistantMedicalService;
import com.manager.CampChildreanHolydayManager.service.BenificierService;
import com.manager.CampChildreanHolydayManager.service.EconomisteService;
import com.manager.CampChildreanHolydayManager.service.FicheMedicaleService;
import com.manager.CampChildreanHolydayManager.service.MoniteurService;
import com.manager.CampChildreanHolydayManager.service.PersonneService;
import com.manager.CampChildreanHolydayManager.service.ProgrammeAlimentaireService;



@Controller
public class AppController {
	
	  

		          ////////////Personne//////////////
	
	  @Autowired
	    private PersonneService service;
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  // enregistre new personne
	  @RequestMapping("/Ajouter_Personne")
	  public String showNewProductPage(Model model) {
		  Personne personne = new Personne();
	      model.addAttribute("personne", personne);
	       
	      return "new_personne";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String savePersonne(@ModelAttribute("personne") Personne personne) {
	      service.save(personne);
	       
	      return "redirect:/Ajouter_Personne";
	  }
	  
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  //affiche la liste de personne
	  @RequestMapping("/affiche_personne")
	  public String viewHomePage( Model model) {
		  List<Personne> listPersonne = service.findAll();
		  model.addAttribute("listPersonne",listPersonne);
		  return "affiche_personne";
		  
	  }
	 //page edit
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/personne/edit/{id}")
	  public ModelAndView showEditPersonnePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_personne");
	      Personne personne = service.get(id);
	      mav.addObject("personne", personne);
	      return mav;
	  }
	  
	
	  
	  // page delete de personne
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/personne/delete/{id}")
	  public String deletePersonne(@PathVariable(name = "id") int id) {
	      service.deleteById(id);
		 return "redirect:/affiche_personne"; 
		
	      
	  }
	  //radio genre
	  @RequestMapping({ "/", "/index" })
	  public class IndexController {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("personne", new Personne());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(Personne personne, Model model) {
	          model.addAttribute("personne", personne);
	          return "saved";
	      }
	  }
	 
	  // search
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping(value = "/search") public String
	  Search(@RequestParam("keyword") String keyword, Model model) throws Exception
	  {
	  
	  if(keyword != null){ List<Personne> Result = service.search("%"+keyword+"%");
	  model.addAttribute("Result", Result); }
	  
	  return "search_personne"; }
	  /*
	 //Download  an Excel document
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @GetMapping("/download/Personne.csv") public void
	  downloadCsv(HttpServletResponse response) throws IOException {
	  response.setContentType("text/csv");
	  response.setHeader("Content-Disposition", "attachment; file=Personne.csv");
	  
	  ExcelPersonne.downloadCsv(response.getWriter(),service.findAll()); }*/
	  
	 
	  
	  
	  
	 
	/////Economiste/////

	  @Autowired
	    private EconomisteService Eservice;
	  // enregistre new economiste
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/Ajouter_Economiste")
	  public String showNewEconomistePage(Model model) {
		  Economiste economiste = new Economiste();
	      model.addAttribute("economiste", economiste);
	       
	      return "new_economiste";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/saveeconomiste", method = RequestMethod.POST)
	  public String saveEconomiste(@ModelAttribute("economiste") Economiste economiste) {
	      Eservice.save(economiste);
	       
	      return "redirect:/Ajouter_Economiste";
	  }
	  
	  //radio genre
	  @RequestMapping({ "/", "/index" })
	  public class IndexControllerE {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("economiste", new Economiste());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(Economiste economiste, Model model) {
	          model.addAttribute("economiste", economiste);
	          return "saved";
	      }
	  }
	  
	
	  //affiche la liste de economiste
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/affiche_economiste") public String vieweconomisteePage(
	  Model model) { List<Economiste> listEconomiste = Eservice.findAll();
	  model.addAttribute("listEconomiste",listEconomiste); return
	  "affiche_economiste";
	  
	  } //page edit
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/economiste/edit/{id}") public ModelAndView
	  showEditEconomistePage(@PathVariable(name = "id") int id) { ModelAndView mav
	  = new ModelAndView("edit_economiste"); Economiste economiste =
	  Eservice.get(id); mav.addObject("economiste", economiste); return mav; }
	  
	  
	  
	  // page delete de economiste
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/economiste/delete/{id}") public String
	  deleteEconomiste(@PathVariable(name = "id") int id) {
	  Eservice.deleteById(id); return "redirect:/affiche_economiste";
	  
	  
	  }
	  
	  
	  // search
	  @Secured(value= {"ROLE_ADMIN","ROLE_economiste","ROLE_Personne"})
	  @RequestMapping(value = "/searcheconomiste") public String
	  Searcheconomiste(@RequestParam("keyword") String keyword, Model model) throws
	  Exception {
	  
	  if(keyword != null){ List<Economiste> Result =
	  Eservice.search("%"+keyword+"%"); model.addAttribute("Result", Result); }
	  
	  return "search_personne"; }
	  
	 
	  
	 //Download  an Excel document
	/*
	 * @GetMapping("/download/Economiste.csv") public void
	 * downloadCsvEconomiste(HttpServletResponse response) throws IOException {
	 * response.setContentType("text/csv");
	 * response.setHeader("Content-Disposition", "attachment; file=Economiste.csv");
	 * 
	 * ExcelPersonne.downloadCsvEconomiste(response.getWriter(),Eservice.findAll());
	 * }
	 */
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	/////Moniteur//////
	  
	  @Autowired
	    private MoniteurService Mservice;
	  
	  // enregistre new moniteur
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/moniteur")
	  public String showNewMoniteurPage(Model model) {
		  Moniteur moniteur = new Moniteur();
	      model.addAttribute("moniteur", moniteur);
	       
	      return "new_moniteur";
	  }
	  
	  // enregistre  new inscription
	  @RequestMapping(value = "/savemoniteur", method = RequestMethod.POST)
	  public String saveMoniteur(@ModelAttribute("moniteur") Moniteur moniteur) {
	      Mservice.save(moniteur);
	       
	      return "redirect:/moniteur";
	  }
	  
	  //affiche la liste de moniteur
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/affiche_moniteur")
	  public String viewHomeMoniteurPage( Model model) {
		  List<Moniteur> listMoniteur = Mservice.listAll();
		  model.addAttribute("listMoniteur",listMoniteur);
		  return "affiche_moniteur";
	  }
	  
	 //page edit MONITEUR
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/moniteur/edit/{id}")
	  public ModelAndView showEditMoniteurPage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_moniteur");
	      Moniteur moniteur = Mservice.get(id);
	      mav.addObject("moniteur", moniteur);
	      return mav;
	  }
	    
	  // page delete de mONITEUR
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/moniteur/delete/{id}")
	  public String deleteMoniteur(@PathVariable(name = "id") int id) {
	      Mservice.delete(id);
	      return "redirect:/affiche_moniteur";       
	  }
	  
	  //radio genre moniteur
	  
	  @RequestMapping({ "/", "/index" })
	  public class IndexControllerM {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("moniteur", new Moniteur());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(Moniteur moniteur, Model model) {
	          model.addAttribute("moniteur", moniteur);
	          return "saved";
	      }
	  }
	  // search moniteur
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping(value = "/searchmoniteur") public String
	  Searchmoniteur(@RequestParam("keyword") String keyword, Model model) throws Exception
	  {
	  
	  if(keyword != null){
	  List<Moniteur> Result = Mservice.searchmoniteur("%"+keyword+"%");
	  model.addAttribute("Result", Result); }
	 
	  return "search_moniteur";   }
/*	  
 //Download  an Excel document
	  
	  @GetMapping("/download/Moniteur.csv") public void
	  downloadCsvMoniteur(HttpServletResponse response) throws IOException {
	  response.setContentType("text/csv");
	  response.setHeader("Content-Disposition", "attachment; file=Moniteur.csv");
	  
	  ExcelMoniteur.downloadCsvMoniteur(response.getWriter(),Mservice.listAll()); }*/
	  
	 
	  								/*Benificier*/
	  
	  @Autowired
	    private BenificierService Bservice;
	  
	  // enregistre new Benificier
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/Ajouter_Benificier")
	  public String showNewBenificierPage(Model model) {
		  Benificier benificier = new Benificier();
	      model.addAttribute("benificier", benificier);
	       
	      return "new_benificier";
	  }
	  
	  // enregistre  new Benificier
	  @RequestMapping(value = "/save2", method = RequestMethod.POST)
	  public String saveBenificier(@ModelAttribute("benificier") Benificier benificier) {
	      Bservice.save(benificier);
	       
	      return "redirect:/Ajouter_Benificier";
	  }
	
	  //affiche la liste de Benificier
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/affiche_Benificier")
	  public String viewPage( Model model) {
		  List<Benificier> listBenificier = Bservice.listAll();
		  model.addAttribute("listBenificier",listBenificier);
		  return "affiche_benificier";
		  
	  }
	
	 //page edit
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/benificier/edit/{id}")
	  public ModelAndView showEditBenificierPage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_benificier");
	      Benificier benificier = Bservice.get(id);
	      mav.addObject("benificier", benificier);
	      return mav;
	  }
	  
	 
	  // page delete Benificier
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping("/benificier/delete/{id}")
	  public String deleteBenificier(@PathVariable(name = "id") int id) {
	      Bservice.delete(id);
	      return "redirect:/affiche_Benificier";       
	  }
	  
	  //radio genre
	  @RequestMapping({ "/", "/index" })
	  public class IndexControllerB {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("benificier", new Benificier());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(Benificier benificier, Model model) {
	          model.addAttribute("benificier", benificier);
	          return "saved";
	      }
	  }
	  // search benificier
	  @Secured(value= {"ROLE_ADMIN","ROLE_Personne"})
	  @RequestMapping(value = "/searchbenificier") public String
	  Searchbenificier(@RequestParam("keyword") String keyword, Model model) throws Exception
	  {
	  
	  if(keyword != null){
	  List<Benificier> Result = Bservice.searchbenificier("%"+keyword+"%");
	  model.addAttribute("Result", Result); }
	 
	  return "search_benificier";   }
	  
	  
	  						////// FicheMedicale  /////

	  @Autowired
	  private FicheMedicaleService FMservice;
	  
	  // enregistre new Fiche Medicale
	  @Secured(value= {"ROLE_ADMIN","ROLE_assistentmedical"})
	  @RequestMapping("/Ajouter_fiche_medicale")
	  public String showNewFicheMedicalePage(Model model) {
		  FicheMedicale fichemedicale = new FicheMedicale();
	      model.addAttribute("fichemedicale", fichemedicale);
	       
	      return "new_fichemedicale";
	  }
	  // enregistre  new inscription 
	  @RequestMapping(value = "/saveFicheMedicale", method = RequestMethod.POST)
	  public String saveFicheMedicale(@ModelAttribute("fichemedicale") FicheMedicale fichemedicale) {
	      FMservice.save(fichemedicale);
	       
	      return "redirect:/Ajouter_fiche_medicale";
	  }
	  //affiche la liste de Fiche Medicale
	  @Secured(value= {"ROLE_ADMIN","ROLE_assistentmedical","ROLE_Personne"})
	  @RequestMapping("/affiche_fichemedicale")
	  public String viewPageFicheMedicale( Model model) {
		  List<FicheMedicale> listFicheMedicale = FMservice.listAll();
		  model.addAttribute("listFicheMedicale",listFicheMedicale);
		  return "affiche_FicheMedicale";
		  
	  }
		 //page edit Fiche Medicale
	  @Secured(value= {"ROLE_ADMIN","ROLE_assistentmedical"})
	  @RequestMapping("/fichemedicale/edit/{id}")
	  public ModelAndView showEditFicheMedicalePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_fichemedicale");
	      FicheMedicale fichemedicale = FMservice.get(id);
	      mav.addObject("fichemedicale", fichemedicale);
	      return mav;
	  }
	  	  
	  // page delete de Fiche Medicale
	  @Secured(value= {"ROLE_ADMIN","ROLE_assistentmedical"})
	  @RequestMapping("/fichemedicale/delete/{id}")
	  public String deleteFicheMedicale(@PathVariable(name = "id") int id) {
	      FMservice.delete(id);
	      return "redirect:/affiche_personne";       
	  }
	  
	  //radio genre
	/*
	 * @RequestMapping({ "/", "/index" }) public class IndexControllerFM {
	 * 
	 * @GetMapping public String main(Model model) {
	 * model.addAttribute("fichemedicale", new FicheMedicale()); return "index"; }
	 * 
	 * @PostMapping public String saveradio(FicheMedicale fichemedicale, Model
	 * model) { model.addAttribute("fichemedicale", fichemedicale); return "saved";
	 * } }
	 */
	  //radio genre
	  @RequestMapping({ "/", "/index" })
	  public class Indexfichemedicale {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("fichemedicale", new FicheMedicale());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(FicheMedicale fichemedicale, Model model) {
	          model.addAttribute("fichemedicale", fichemedicale);
	          return "saved";
	      }
	  }
	  // search benificier
	  @Secured(value= {"ROLE_ADMIN","ROLE_assistentmedical","ROLE_Personne"})
	  @RequestMapping(value = "/searchfichemedicale") public String
	  Searchfichemedicale(@RequestParam("keyword") String keyword, Model model) throws Exception
	  {
	  
	  if(keyword != null){
	  List<FicheMedicale> Result = FMservice.searchfichemedicale("%"+keyword+"%");
	  model.addAttribute("Result", Result); }
	 
	  return "search_fichemedicale";   }
	  
	  
	  						////////programmealimentaire////////
	  @Autowired
	    private ProgrammeAlimentaireService PAservice;
	  // enregistre  programme alimentaire
	  @RequestMapping("/programmealimentaire")
	  public String showNewProgrammeAlimentairePage(Model model) {
		  ProgrammeAlimentaire programmealimentaire = new ProgrammeAlimentaire();
	      model.addAttribute("programmealimentaire", programmealimentaire);
	       
	      return "new_programmealimentaire";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/saveprogrammealimentaire", method = RequestMethod.POST)
	  public String saveProgrammeAlimentaire(@ModelAttribute("programmealimentaire") ProgrammeAlimentaire programmealimentaire) {
	      PAservice.save(programmealimentaire);
	       
	      return "redirect:/programmealimentaire";
	  }
	  //affiche la liste de programme alimentaire
	  @RequestMapping("/affiche_programmealimentaire")
	  public String viewHomeProgrammeAlimentairePage( Model model) {
		  List<ProgrammeAlimentaire> listProgrammeAlimentaire = PAservice.listAll();
		  model.addAttribute("listProgrammeAlimentaire",listProgrammeAlimentaire);
		  return "affiche_programmealimentaire";
		  
	  }
	 //page edit
	  @RequestMapping("/programmealimentaire/edit/{id}")
	  public ModelAndView showEditProgrammeAlimentairePage(@PathVariable(name = "id") int id) {
	      ModelAndView mav = new ModelAndView("edit_programmealimentaire");
	      ProgrammeAlimentaire programmealimentaire = PAservice.get(id);
	      mav.addObject("programmealimentaire", programmealimentaire);
	      return mav;
	  }
	  
	
	  
	  // page delete de programme alimentaire
	  @RequestMapping("/programmealimentaire/delete/{id}")
	  public String deleteProgrammeAlimentaire(@PathVariable(name = "id") int id) {
	     PAservice.delete(id);
	      return "redirect:/affiche_programmealimentaire";       
	  }
	  
	  
	  //choose file
	  @RequestMapping("/")
	  public class FileUploadController {

	      @GetMapping
	      public String main() {
	          return "index";
	      }

	      @PostMapping
	      public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	          redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

	          return "redirect:/";
	      }
	  }
	  //download file
	  // search programmealimentaire
		
		/*
		 * @RequestMapping(value = "/searchprogrammealimentaire") public String
		 * Searchprogrammealimentaire(@RequestParam("keyword") String keyword, Model
		 * model) throws Exception {
		 * 
		 * if(keyword != null){ List<ProgrammeAlimentaire> Result =
		 * PAservice.searchprogrammealimentaire("%"+keyword+"%");
		 * model.addAttribute("Result", Result); }
		 * 
		 * return "search_programmealimentaire"; }
		 */
	  
	  
	  
		  
			//////Activite///////
	@Autowired
	private ActiviteService Aservice;
	// enregistre new Activite
	@RequestMapping("/activite")
	public String showNewActivitePage(Model model) {
	Activite activite = new Activite();
	model.addAttribute("activite", activite);
	
	return "new_activite";
	}
	// enregistre  new activite
	@RequestMapping(value = "/saveactivite", method = RequestMethod.POST)
	public String saveActivite(@ModelAttribute("activite") Activite activite) {
	Aservice.save(activite);
	
	return "redirect:/activite";
	}
	//affiche la liste de activite
	@RequestMapping("/affiche_activite")
	public String viewHomeactivitePage( Model model) {
	List<Activite> listActivite = Aservice.listAll();
	model.addAttribute("listActivite",listActivite);
	return "affiche_activite";
	
	}
	//page edit activite id
	@RequestMapping("/activite/edit/{id}")
	public ModelAndView showEditActivitePage(@PathVariable(name = "id") int id) {
	ModelAndView mav = new ModelAndView("edit_activite");
	Activite activite = Aservice.get(id);
	mav.addObject("activite", activite);
	return mav;
	}
	
	
	
	// page delete de activite
	@RequestMapping("/activite/delete/{id}")
	public String deleteActivite(@PathVariable(name = "id") int id) {
	Aservice.delete(id);
	return "redirect:/affiche_activite";       
	}
	
	// search activite
	
	
	@RequestMapping(value = "/searchactivite") public String
	Searchactivite(@RequestParam("keyword") String keyword, Model model) throws Exception {
	
	if(keyword != null){ List<Activite> Result =
	Aservice.searchactivite("%"+keyword+"%"); model.addAttribute("Result",
	Result); }
	
	return "search_activite"; }

////////Assistant   Medical////////
	  @Autowired
	    private AssistantMedicalService AMservice;
	  // enregistre  assistant medical
	  @RequestMapping("/assistantmedical")
	  public String showNewassistantmedicalPage(Model model) {
		  AssistantMedical assistantmedical= new AssistantMedical ();
	      model.addAttribute("assistantmedical", assistantmedical);
	       
	      return "new_assistantmedical";
	  }
	  // enregistre  new inscription
	  @RequestMapping(value = "/saveassistantmedical", method = RequestMethod.POST)
	  public String saveassistantmedical (@ModelAttribute("assistantmedical") AssistantMedical assistantmedical) {
	      AMservice.save(assistantmedical);
	       
	      return "redirect:/assistantmedical";
	  }

	  //radio genre
	  @RequestMapping({ "/", "/index" })
	  public class IndexControllerAssistantMedical {

	      @GetMapping
	      public String main(Model model) {
	          model.addAttribute("assistantmedical", new AssistantMedical());
	          return "index";
	      }

	      @PostMapping
	      public String saveradio(AssistantMedical assistantmedical, Model model) {
	          model.addAttribute("assistantmedical", assistantmedical);
	          return "saved";
	      }
	  }
	  

	  
	
	  //affiche la liste de assistant medical
	  
	  @RequestMapping("/affiche_assistantmedical") public String
	  viewHomeAssistantMedicalPage( Model model) { 
	 List<AssistantMedical>  listassistantmedical = AMservice.findAll();
	  model.addAttribute("listassistantmedical",listassistantmedical); return
	  "affiche_assistantmedical";
	  
	  } //page edit
	  
	  @RequestMapping("/assistantmedical/edit/{id}") public ModelAndView
	  showEditAssistantMedicalPage(@PathVariable(name = "id") int id) {
	  ModelAndView mav = new ModelAndView("edit_assistantmedical");
	  AssistantMedical assistantmedical= AMservice.get(id);
	  mav.addObject("assistantmedical", assistantmedical); return mav; }
	  
	  
	  
	  // page delete de assistant medical
	  
	  @RequestMapping("/assistantmedical/delete/{id}") public String
	  deleteAssistantMedical (@PathVariable(name = "id") int id) {
	  AMservice.deleteById(id);
	  return "redirect:/affiche_assistantmedical"; }
	 
	  // search moniteur
		
	  @RequestMapping(value = "/searchassistantmedical") public String
	  Searchassistantmedical(@RequestParam("keyword") String keyword, Model model) throws Exception
	  {
	  
	  if(keyword != null){
	  List<AssistantMedical> Result = AMservice.searchassistantmedical("%"+keyword+"%");
	  model.addAttribute("Result", Result); }
	 
	  return "search_moniteur";   }

	 
	  				
}
