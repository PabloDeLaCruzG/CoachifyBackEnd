package com.pablodelacruz.coachify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CoachifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachifyApplication.class, args);
	}

}
