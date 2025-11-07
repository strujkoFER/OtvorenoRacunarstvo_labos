package com.backend.programski_jezici;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class ProgramskiJeziciApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramskiJeziciApplication.class, args);
	}

}
