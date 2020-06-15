package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.mariadb.city.City;
import com.example.demo.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {
	@Autowired
	CityService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getCityById() {
		City city = service.getCityById(1);
		System.out.println(city.getCountry());
	}
	

}
