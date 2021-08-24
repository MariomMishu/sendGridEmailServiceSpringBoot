package com.example.sendGridEmailService.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.sendGridEmailService.email.EmailService;

@Component
public class InitializeData implements CommandLineRunner{
	
    @Autowired 
    EmailService sendGridEmailService;

	@Override
	public void run(String... args) throws Exception {
		
		this.sendGridEmailService.sendHTML( "mishu.cste08@gmail.com", "mariom.akter@brainstation-23.com", "Hello World", "Hello, <strong>how are you doing?</strong>");
		    
	}

}
