package com.example.demo.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	CityService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//call service for reading auth policy from resources.
//		int id = 1;
//		City city = service.getCityById(id);
		//System.out.println();
		
		
		System.out.println("[SpringSecurityConfig][configure]");
		
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/city/**").authenticated();
				//.antMatchers("/library/**").permitAll();
		http.formLogin().permitAll();		//use default login page.
		//http.formLogin().loginPage("/login");
		//http.logout().logoutUrl("/logout");
	}
	
	
}
