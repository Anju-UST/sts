package com.ust.service1.ctrlr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service")
public class HelloService {
	@Value("${spring.application.name}")
	String message;
	
	@GetMapping
	public String firstservice(){
		return "welcome to "+message;
	}
	@GetMapping
	@RequestMapping("second")
	public String demo() {
		return "up and running"+message;
	}
	@GetMapping
	@RequestMapping("status")
	public String status() {
		return "running on port 8091"+message;
	}

}
