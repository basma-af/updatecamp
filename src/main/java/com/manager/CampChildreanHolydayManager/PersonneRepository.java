package com.manager.CampChildreanHolydayManager;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/*Comme vous pouvez le voir, cette interface étend l'interface JpaRepository
à partir de Spring Data JPA. 
JpaRepository définit des méthodes CRUD standard, 
ainsi que des opérations spécifiques à JPA.
Nous n'avons pas à écrire de code d'implémentation 
car Spring Data JPA générera le code nécessaire au moment de l'exécution, 
sous forme d'instances proxy.
Le but de l'écriture de l'interface du référentiel est donc d'indiquer
à Spring Data JPA le type de domaine (Produit) et le type ID (Long) 
avec lesquels travailler.*/
public interface PersonneRepository extends JpaRepository<Personne, Long>{
	

	
	@Query(value="select * from Personne p where  p.Genre LIKE   :keyword or   p.CIN LIKE :keyword or  p.Nom LIKE :keyword or p.Prenom LIKE :keyword or  p.Diplome LIKE  :keyword or p.email LIKE   :keyword or p.numero_Tel LIKE   :keyword or  p.tache LIKE  :keyword   ", nativeQuery = true)
	
	List<Personne> search(@Param("keyword") String keyword);

	 
}

