package com.onedigitalinnovation.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/people")
public class PersonapiApplication {


	public String getBook() {
		return "API test";
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);
	}

}
