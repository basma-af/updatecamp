package com.manager.CampChildreanHolydayManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.Entites.Benificier;
import com.manager.CampChildreanHolydayManager.dao.BenificierRepository;

@Service
@Transactional
public class BenificierService {
    @Autowired
    private BenificierRepository Brepo;
     
    public List<Benificier> listAll() {
        return Brepo.findAll();
    }
     
    public void save(Benificier benificier) {
        Brepo.save(benificier);
    }
     
    public Benificier get(long id) {
        return Brepo.findById(id).get();
    }
     
    public void delete(long id) {
        Brepo.deleteById(id);
    }
    public List<Benificier>searchbenificier(String keyword){
    	return Brepo.searchbenificier(keyword);
    }
}
