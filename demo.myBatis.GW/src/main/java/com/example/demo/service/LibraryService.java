package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.h2db.library.Library;
import com.example.demo.repository.h2db.library.LibraryMapper;

@Service
public class LibraryService {

	@Autowired
	LibraryMapper libraryMapper;
	
	public Library getLibraryById(int id) {
		return libraryMapper.selectLibraryById(id);
	}
	
	public List<Library> getCityAll(){
		return libraryMapper.selectAllLibrary();
	}
	
	public void insertLibrary(Library lib) {
		libraryMapper.insertLibrary(lib);
	}
}
