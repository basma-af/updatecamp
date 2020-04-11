package com.manager.CampChildreanHolydayManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manager.CampChildreanHolydayManager.Entites.Benificier;

public interface BenificierRepository  extends JpaRepository<Benificier, Long> {
@Query(value="select * from Benificier B where   B.Nom LIKE :keyword or B.Prenom LIKE :keyword or  B.Date_Naissance LIKE  :keyword  or B.Tuteur_Nom_Complet LIKE  :keyword or   B.CIN LIKE :keyword or B.Email LIKE   :keyword or  B.Addresse LIKE  :keyword  or B.numero_Tel LIKE   :keyword or  B.Profession LIKE  :keyword or  B.Moniteur LIKE  :keyword or B.Genre LIKE   :keyword or  B.Lieu LIKE  :keyword", nativeQuery = true)
	
	List<Benificier> searchbenificier(@Param("keyword") String keyword);
}
