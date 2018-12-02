package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
//@ComponentScan(basePackages = {"com.controller","com.service"})
//@EnableJpaRepositories("com.repository")
//@EntityScan( "com.entity" )
public class TransporteApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransporteApplication.class, args);
	}
}
