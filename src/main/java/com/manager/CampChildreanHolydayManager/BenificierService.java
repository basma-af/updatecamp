package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
