package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	MessageSource ms;
	
	@GetMapping("/notfound")
	public String notFound(Locale locale) {
		System.out.println("[MessageController][notFound]" + locale);
		
		return ms.getMessage("msg.notfound", null, locale);
	}
}
