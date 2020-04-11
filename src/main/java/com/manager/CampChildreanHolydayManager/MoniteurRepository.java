package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {

	@Query(value="select * from Moniteur m where  m.Genre LIKE   :keyword or   m.CIN LIKE :keyword or  m.Nom LIKE :keyword or m.Prenom LIKE :keyword or  m.Diplome LIKE  :keyword or m.email LIKE   :keyword or m.numero_Tel LIKE   :keyword or  m.tache LIKE  :keyword   ", nativeQuery = true)
	
	List<Moniteur> searchmoniteur(@Param("keyword") String keyword);
}
