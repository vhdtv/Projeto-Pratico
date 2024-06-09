package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = { "com.example" })
@EntityScan("com.example.models")
public class PacientDataManager {

	public static void main(String[] args) {
		SpringApplication.run(PacientDataManager.class, args);
	}

}
