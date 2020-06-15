package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.mariadb.city.City;
import com.example.demo.repository.mariadb.city.CityMapper;

@Service
@Transactional
public class CityService {
	
	@Autowired
	CityMapper cityMapper;

	public City getCityById(int id) {
		return cityMapper.selectCityById(id);
	}
	
	public List<City> getCityAll(){
		return cityMapper.selectAllCity();
	}
	
	public void insertCity(City city) {
		cityMapper.insertCity(city);
	}
}
