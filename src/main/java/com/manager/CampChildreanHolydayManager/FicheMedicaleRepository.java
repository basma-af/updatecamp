package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FicheMedicaleRepository extends JpaRepository<FicheMedicale, Long> {
	@Query(value="select * from fiche_medicale FM where FM.date LIKE   :keyword or   FM.cas LIKE :keyword or  FM.Nom_Respensable_Medicale LIKE :keyword or FM.Nom_benificier LIKE :keyword or FM.Prenom_benificier LIKE   :keyword or   FM.Moniteur LIKE :keyword or  FM.Equipe LIKE :keyword or FM.Decription LIKE :keyword ", nativeQuery = true)
	
	List<FicheMedicale> searchfichemedicale(@Param("keyword") String keyword);

}
