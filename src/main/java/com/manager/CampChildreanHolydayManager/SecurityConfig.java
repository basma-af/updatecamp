package com.manager.CampChildreanHolydayManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private void globalConfig(AuthenticationManagerBuilder  auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN"
		 * ); auth.inMemoryAuthentication().withUser("personne").password("123").roles(
		 * "personne");
		 * auth.inMemoryAuthentication().withUser("economiste").password("123").roles(
		 * "economiste");
		 * auth.inMemoryAuthentication().withUser("assistentmedical").password("123").
		 * roles("assistentmedical");
		 * auth.inMemoryAuthentication().withUser("moniteur").password("123").roles(
		 * "moniteur");
		 */
		
		
		 auth.inMemoryAuthentication()
		  .withUser("admin").password("{noop}admin").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest()
					.authenticated()
						.and()
		    .formLogin()
		    	.loginPage("/login")
		    		.permitAll();
	}
}
