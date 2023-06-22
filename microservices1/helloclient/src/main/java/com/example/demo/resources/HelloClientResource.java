package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class HelloClientResource {
@Autowired
RestTemplate template;

@GetMapping("/server")
public String  callServer() {
	//for direct execution of service
//	String url="http://localhost:8094/rest/server";
	String url="http://localhost:8093/rest/server/status";
	
	String output=template.getForObject(url, String.class);
			return output;
}
@GetMapping("/billing")
public String billingserver() {
	String url="http://localhost:8093/billing/server";
	String output=template.getForObject(url, String.class);
	return output;
}
}
