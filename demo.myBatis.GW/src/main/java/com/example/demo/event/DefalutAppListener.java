package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.service.LibraryService;

@Component
public class DefalutAppListener {

	@Autowired
	LibraryService service;
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReadyEvent() {
		
		System.out.println("[DefalutAppListener][onApplicationReadyEvent]" + service.getLibraryById(1).getCity());
	}
	
	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationStartedEvent() {
		System.out.println("[DefalutAppListener][onApplicationReadyEvent]" + service.getLibraryById(1).getCity());
	}

}
