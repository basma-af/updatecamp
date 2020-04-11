package com.manager.CampChildreanHolydayManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.dao.ProgrammeAlimentaire;
import com.manager.CampChildreanHolydayManager.dao.ProgrammeAlimentaireRepository;


@Service
@Transactional
public class ProgrammeAlimentaireService {
	 @Autowired
	    private ProgrammeAlimentaireRepository PArepo;
	     
	    public List<ProgrammeAlimentaire> listAll() {
	        return PArepo.findAll();
	    }
	     
	    public void save(ProgrammeAlimentaire programmealimentaire) {
	        PArepo.save(programmealimentaire);
	    }
	     
	    public ProgrammeAlimentaire get(long id) {
	        return PArepo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        PArepo.deleteById(id);
	    }
	    /*
		 * public List<ProgrammeAlimentaire>searchprogrammealimentaire(String keyword){
		 * return PArepo.searchprogrammealimentaire(keyword); }
		 */
	
}

   
