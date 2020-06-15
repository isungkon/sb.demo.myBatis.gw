package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.h2db.library.Library;
import com.example.demo.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/library/{id}")
	public String getLibraryById(@PathVariable int id) {
		Library lib = libraryService.getLibraryById(id);
		System.out.println(lib.getName());
		return lib.getName();
	}
}
