package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipeService {
    @Autowired
    private EquipeRepository Eqrepo;
     
    public List<Equipe> listAll() {
        return Eqrepo.findAll();
    }
     
    public void save(Equipe equipe) {
        Eqrepo.save(equipe);
    }
     
    public Equipe get(long id) {
        return Eqrepo.findById(id).get();
    }
     
    public void delete(long id) {
        Eqrepo.deleteById(id);
    }
	/*
	 * public List<Equipe> find(String Nom){ return Eqrepo.find(Nom); }
	 */
 
}
