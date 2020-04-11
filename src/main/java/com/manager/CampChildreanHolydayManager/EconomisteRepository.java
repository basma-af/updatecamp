package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EconomisteRepository extends  JpaRepository<Economiste, Long>{
	
	  @Query(
	  value="select * from Economiste e where  p.Genre LIKE   :keyword or   p.CIN LIKE :keyword or  p.Nom LIKE :keyword or p.Prenom LIKE :keyword or  p.Diplome LIKE  :keyword or p.email LIKE   :keyword or p.numero_Tel LIKE   :keyword or  p.tache LIKE  :keyword ", nativeQuery = true)
	  
	  List<Economiste> search(@Param("keyword") String keyword);
	 

}
