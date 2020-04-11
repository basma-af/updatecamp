package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FicheMedicaleService {
			@Autowired
		    private FicheMedicaleRepository FMrepo;
		     
		    public List<FicheMedicale> listAll() {
		        return FMrepo.findAll();
		    }
		     
		    public void save(FicheMedicale fichemedicale) {
		        FMrepo.save(fichemedicale);
		    }
		     
		    public FicheMedicale get(long id) {
		        return FMrepo.findById(id).get();
		    }
		     
		    public void delete(long id) {
		        FMrepo.deleteById(id);
		    }
		    public List<FicheMedicale> searchfichemedicale(String keyword){
		    	return FMrepo.searchfichemedicale(keyword);
		    }
}
