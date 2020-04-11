package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  EquipeRepository extends JpaRepository<Equipe, Long>{
	/*
	 * @Query("SELECT Nom FROM moniteur m WHERE equipe(m.Nom) = equipe(:Nom)")
	 * public List<Equipe> find(@Param("Nom") String Nom);
	 */

}
