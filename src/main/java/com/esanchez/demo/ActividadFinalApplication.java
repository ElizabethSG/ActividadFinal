package com.esanchez.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.esanchez.demo.controller","com.esanchez.demo.service"})
@EntityScan("com.esanchez.demo.entity")
@EnableJpaRepositories("com.esanchez.demo.repository")
public class ActividadFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActividadFinalApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
