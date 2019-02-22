package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.bookstore")
public class SpringBootBookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookstoreApplication.class, args);
	}

}
