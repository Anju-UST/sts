package com.ust.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.shopping.dto.ProductRequest;
import com.ust.shopping.services.ProductService;

@RestController
@RequestMapping("/project/product")
public class ProductController {
	@Autowired
	ProductService service;
	
	@PostMapping
	@RequestMapping("/create")
	public ResponseEntity<?> create (@RequestBody @Valid ProductRequest request  ){
		
		return new ResponseEntity<>(service.createProduct(request),HttpStatus.CREATED);
		
	}
	@GetMapping
	@RequestMapping("/getall")
	public ResponseEntity<List<ProductRequest>>getProducts(){
		return null;
		
		
	}
	
}
