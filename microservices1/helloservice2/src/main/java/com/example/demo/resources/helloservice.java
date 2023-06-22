package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/server")
public class helloservice {
 @Autowired
 Environment environment;//reference to properties

 @GetMapping
 public String welcome() {
	String port=environment.getProperty("server.port");
	 return "welcome to @ "+port;
	 }
 @GetMapping("/status")
	 public String status() {
		 return "up and running";
	 }
 }