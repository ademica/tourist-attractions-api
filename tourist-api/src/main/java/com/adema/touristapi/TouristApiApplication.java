package com.adema.touristapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TouristApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristApiApplication.class, args);
	}

	@GetMapping("/")
	public String first(){
		return "Project initialization";
	}

}
