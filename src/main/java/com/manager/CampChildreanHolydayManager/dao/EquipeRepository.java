package com.manager.CampChildreanHolydayManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.manager.CampChildreanHolydayManager.Entites.Equipe;

public interface  EquipeRepository extends JpaRepository<Equipe, Long>{
	
	@Query(value="SELECT m.Nom , m.Prenom  FROM  moniteur m  inner join equipe e on e.moniteur_id = m.id ", nativeQuery = true)
	
	    public List<Equipe> getJoinInformation();
	
	
	
	/*
	 * @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p"
	 * ) public List<OrderResponse> getJoinInformation();
	 */
}
