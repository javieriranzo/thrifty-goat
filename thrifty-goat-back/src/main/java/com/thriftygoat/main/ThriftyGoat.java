package com.thriftygoat.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.thriftygoat.repository"})
public class ThriftyGoat {

	public static void main (String[] args) {
		SpringApplication.run(ThriftyGoat.class, args);
	}
	
}
