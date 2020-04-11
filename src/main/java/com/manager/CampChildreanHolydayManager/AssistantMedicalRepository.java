package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssistantMedicalRepository extends JpaRepository<AssistantMedical, Long>{
	
	@Query(value="select * from assistant_medical AM where  AM.Genre LIKE   :keyword or   AM.CIN LIKE :keyword or  AM.Nom LIKE :keyword or AM.Prenom LIKE :keyword or  AM.Diplome LIKE  :keyword or AM.email LIKE   :keyword or AM.numero_Tel LIKE   :keyword or  AM.tache LIKE  :keyword   ", nativeQuery = true)
	
	List<AssistantMedical> searchassistantmedical(@Param("keyword") String keyword);

}
