package com.capstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.capstore"})
public class CapStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoreApplication.class, args);
	}
}
