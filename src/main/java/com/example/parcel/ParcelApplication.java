package com.example.parcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ParcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcelApplication.class, args);
	}

}
