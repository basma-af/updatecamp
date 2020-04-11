package com.manager.CampChildreanHolydayManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.Entites.AssistantMedical;
import com.manager.CampChildreanHolydayManager.dao.AssistantMedicalRepository;

@Service
@Transactional
public class AssistantMedicalService {
    @Autowired
    private AssistantMedicalRepository AMrepo;
     
    public List<AssistantMedical> findAll() {
        return AMrepo.findAll();
    }
     
    public void save(AssistantMedical AssistantMedical) {
        AMrepo.save(AssistantMedical);
    }
     
    public AssistantMedical get(long id) {
        return AMrepo.findById(id).get();
    }
     
    public void deleteById(long id) {
        AMrepo.deleteById(id);
    }
	
	
    public List<AssistantMedical>searchassistantmedical(String keyword){
    	return AMrepo.searchassistantmedical(keyword);
    }
}
