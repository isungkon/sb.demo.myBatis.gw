package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.mariadb.city.City;
import com.example.demo.service.CityService;

@RestController
public class CityController {

	@Autowired
	CityService service;
	
	@GetMapping("/city/{id}")
	public String getCityById(@PathVariable int id) {
		City city = service.getCityById(id);
		System.out.println(city.getCountry());
		return city.getCountry();
	}
	
}
