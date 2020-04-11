package com.manager.CampChildreanHolydayManager.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.Entites.Personne;
import com.manager.CampChildreanHolydayManager.dao.PersonneRepository;

@Service
@Transactional
public class PersonneService {
    @Autowired
    private PersonneRepository repo;
     
    public List<Personne> findAll() {
        return repo.findAll();
    }
     
    public void save(Personne personne) {
        repo.save(personne);
    }
     
    public Personne get(long id) {
        return repo.findById(id).get();
    }
     
    public void deleteById(long id) {
        repo.deleteById(id);
    }
	
	
    public List<Personne>search(String keyword){
    	return repo.search(keyword);
    }

}
