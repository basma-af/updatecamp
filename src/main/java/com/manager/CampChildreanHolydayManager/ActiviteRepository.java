package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{
	@Query(value="select * from Activite A Where A.Type_Activite LIKE   :keyword or   A.Nom_Activite LIKE :keyword or  A.Outils LIKE :keyword or A.Nombre_Participants LIKE :keyword or  A.Objectif LIKE  :keyword or A.Categorie_Cible LIKE   :keyword or A.Description LIKE   :keyword ", nativeQuery = true)
	
	List<Activite> searchactivite(@Param("keyword") String keyword);
}
