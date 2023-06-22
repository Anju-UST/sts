package com.ust.client.ctrlr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class HelloClient {
	@Autowired
	RestTemplate template;
	
	@GetMapping("/server")
	public String call() {
		String url="http://localhost:8093/service";
		String output=template.getForObject(url, String.class);
		return output;
	}
	@GetMapping("/servercall")
	public String servercall() {
		String url="http://localhost:8093/service/second";
		String output=template.getForObject(url, String.class);
		return output;
	}
	@GetMapping("/status")
	public String status() {
		String url="http://localhost:8093/service/status";
		ResponseEntity<String> response= template.getForEntity(url, String.class);
		 String productsJson = response.getBody();
	     return productsJson;
	}
	
	

}
