package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.service.EmailService;

@SpringBootApplication
public class BugProjectApplication {
	
	@Autowired
	EmailService service;

	public static void main(String[] args) {
		SpringApplication.run(BugProjectApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		service.sendSimpleEmail("anki.shetty20@gmail.com", "This is mail is from bug project", "This is email subject");
	}

}
