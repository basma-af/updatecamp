package com.manager.CampChildreanHolydayManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.manager.CampChildreanHolydayManager.Entites.Equipe;

public interface  EquipeRepository extends JpaRepository<Equipe, Long>{
	
	@Query("SELECT new equipe(m.Nom , m.Prenom ,b.Nom , b.Prenom) FROM benificier b JOIN moniteur m ")
	
	    public List<Equipe> getJoinInformation();
	
	
	
	/*
	 * @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p"
	 * ) public List<OrderResponse> getJoinInformation();
	 */
}
