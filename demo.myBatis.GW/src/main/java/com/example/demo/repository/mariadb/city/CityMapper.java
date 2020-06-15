package com.example.demo.repository.mariadb.city;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper {
	
	City selectCityById(int id);
	List<City> selectAllCity();
	void insertCity(City city);

}