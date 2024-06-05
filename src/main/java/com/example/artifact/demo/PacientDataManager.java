package com.example.artifact.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "com.example.artifact.models", "com.example.artifact.dto",
		"com.example.artifact.repositories", "com.example.artifact.controllers" })
@ComponentScan(basePackages = { "com.example.artifact.models", "com.example.artifact.dto",
		"com.example.artifact.repositories", "com.example.artifact.controllers" })
@EntityScan(basePackages = { "com.example.artifact.models", "com.example.artifact.dto",
		"com.example.artifact.repositories", "com.example.artifact.controllers" })
public class PacientDataManager {

	public static void main(String[] args) {
		SpringApplication.run(PacientDataManager.class, args);
	}

}
