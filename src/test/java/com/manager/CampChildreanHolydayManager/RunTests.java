package com.manager.CampChildreanHolydayManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.manager.CampChildreanHolydayManager.Entites.Personne;
import com.manager.CampChildreanHolydayManager.service.PersonneService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class RunTests {

	  @Autowired
	    private MockMvc mockMvc;
	
	@MockBean
	private PersonneService srv;

@Test
public void findAll() throws Exception {
    // given
    Personne personne = new Personne();
    personne.setId(28L);
    personne.setNom("Ayoubi");  
    personne.setPrenom("Rokia");
    personne.setCIN("AC1515");
    personne.setDiplome("Master");
    personne.setTache("Monitrice");
    personne.setNumero_Tel(554588888);
    personne.setEmail("rokiaayoubi@gmail.com");

    List<Personne> personnes = Arrays.asList(personne);
    given(srv.findAll()).willReturn(personnes);

    // when + then
    this.mockMvc.perform(get("/affiche_personne"))
            .andExpect(status().isOk())
            .andExpect(content().json("[{'id': 28,'Nom': 'Ayoubi';'Prenom': 'Rokia'; 'CIN': 'AC1515' ;'Diplome':'Master';'Tache':'Monitrice';'Numero_Tel':554588888;'Email':'rokiaayoubi@gmail.com' }]"));
}









/*
	@Test
	public void testGetPersonne(){ 
	personne = srv.get(28);
	assertEquals("message","Ayoubi",personne.getNom());
		
	}*/
	/*
	@Test
	public void testdeletePersonne() {
	 personne = srv.get(6);
	assertEquals("message", rep.deleteById(6));
	}
	*/
/*
	@Test
	public void testlistPersonne() {

	assertEquals("message",srv.listAll());
	}*/
	
	@Test
	void contextLoads() {

	}

	
	
	

}
