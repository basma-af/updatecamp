package com.manager.CampChildreanHolydayManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@Springbootapplication === annotation fait tous les trucs magiques tels 
que créer l’instance de serveur web et Spring MVC dispatcher servlet.*/

@SpringBootApplication
public class Run {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}

}
