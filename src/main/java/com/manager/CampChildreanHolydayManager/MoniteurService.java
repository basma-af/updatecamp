package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class MoniteurService {
    @Autowired
    private MoniteurRepository Mrepo;
     
    public List<Moniteur> listAll() {
        return Mrepo.findAll();
    }
     
    public void save(Moniteur moniteur) {
        Mrepo.save(moniteur);
    }
     
    public Moniteur get(long id) {
        return Mrepo.findById(id).get();
    }
     
    public void delete(long id) {
        Mrepo.deleteById(id);
    }
    
    public List<Moniteur>searchmoniteur(String keyword){
    	return Mrepo.searchmoniteur(keyword);
    }
    
}



