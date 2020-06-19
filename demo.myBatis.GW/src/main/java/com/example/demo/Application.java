package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.repository")
public class Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
		
//		SpringApplication app = new SpringApplication(Application.class);
//		app.addListeners((ApplicationReadyEvent e)->{
//			System.out.println("[Application][main]-ApplicationReadyEvent");
//		});
//		
//		app.addListeners((ApplicationStartedEvent e)->{
//			System.out.println("[Application][main]-ApplicationStartedEvent");
//		});
//				
//		app.run(args);
		
		SpringApplication.run(Application.class, args);
		
	}

}
