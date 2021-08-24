package com.example.sendGridEmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendGridEmailServiceApplication{
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(new Class[]{SendGridEmailServiceApplication.class}, args);
		System.out.println("Spring Boot Start");
		
		
	}
		

}
