package com.example.demo.repository.h2db.library;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibraryMapper {
	
	Library selectLibraryById(int id);
	List<Library> selectAllLibrary();
	void insertLibrary(Library library);

}