package com.grabit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ECommerceApplication.class);

		Properties props = new Properties();
		try {
			props.load(new FileInputStream("secret.properties"));
		} catch (IOException e) {
			System.err.println("Could not load secret.properties: " + e.getMessage());
		}

		app.setDefaultProperties(props);
		app.run(args);
	}
}