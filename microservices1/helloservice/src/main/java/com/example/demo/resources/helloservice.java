//registry=8761 helloservice=8094  client=8092 gateway=8093
package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/server")
public class helloservice {
 @Value("name")
 String strMessage;
 @GetMapping
 public String welcome() {
	 return "programming microservices"+strMessage;
	 }
 @GetMapping("/status")
	 public String status() {
		 return "up and running";
	 }
 }