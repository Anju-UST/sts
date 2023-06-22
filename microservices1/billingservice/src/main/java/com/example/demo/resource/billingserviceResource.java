
package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/server")
public class billingserviceResource {
	@Value("billing")
	 String strMessage;
@GetMapping
public String billingcall() {
	return "billing approved...."+strMessage;
}
}
