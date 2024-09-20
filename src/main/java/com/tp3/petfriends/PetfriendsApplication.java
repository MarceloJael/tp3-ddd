package com.tp3.petfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tp3.petfriends", "org.axonframework"})
public class PetfriendsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetfriendsApplication.class, args);
	}
}