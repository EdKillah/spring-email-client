package com.personal.srpingemailclient;

import com.personal.srpingemailclient.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SrpingEmailClientApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SrpingEmailClientApplication.class, args);
	}

	/*
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){
		System.out.println("\n\nENTRANDO EN TRIGGER MAIL DEL MAIN\n\n");
		//emailSenderService.sendSimpleEmail("","","");
	}
	 */

}
