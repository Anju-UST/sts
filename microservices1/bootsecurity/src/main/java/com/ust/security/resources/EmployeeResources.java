package com.ust.security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResources {
	
	@GetMapping("/")
	public String greet() {
		return "working";
	}
	@GetMapping
	@RequestMapping("/admin")
	public String greetAdmin() {
		return "admin@Work";
		
	}
	
	@GetMapping
	@RequestMapping("/user")
	public String greetUser() {
		return "User@Work";
	}

}
//because of spring security  password is created
//Using generated security password: 116051da-483e-47de-8552-f6c288549122
