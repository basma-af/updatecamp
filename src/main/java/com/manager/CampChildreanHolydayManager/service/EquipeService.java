package com.manager.CampChildreanHolydayManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.Entites.Equipe;
import com.manager.CampChildreanHolydayManager.dao.EquipeRepository;

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

	public List<Equipe> getJoinInformation() {
		return Eqrepo.getJoinInformation();
	}

}
