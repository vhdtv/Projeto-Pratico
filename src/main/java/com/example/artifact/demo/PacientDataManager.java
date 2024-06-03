package com.example.artifact.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.artifact")
@EntityScan(basePackages = "com.example.artifact.models")
public class PacientDataManager {

	public static void main(String[] args) {
		SpringApplication.run(PacientDataManager.class, args);
	}

}
