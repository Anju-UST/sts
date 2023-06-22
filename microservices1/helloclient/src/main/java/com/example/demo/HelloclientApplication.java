package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//commented as client is before the gateway
//@EnableEurekaClient
@SpringBootApplication
public class HelloclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloclientApplication.class, args);
	}
	//RestTemplate for 2 microservices to communicate via controller
	@Bean
	public RestTemplate makeTemplate() {
		return new RestTemplate();//returning rest template object
	}

}
