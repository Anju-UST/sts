package com.ust.crud.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.crud.Model.Product;
import com.ust.crud.Services.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/product/api.2.0")
public class ProductController {

	@Autowired
	ProductService service;

	
	  @GetMapping
	  @CrossOrigin
	  @RequestMapping("/retrieve/all") 
	  public List<Product> fetchProducts() {
	  return service.getProducts();
	  }
	 

	@PostMapping
	@CrossOrigin
	@RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		boolean result = service.add(product);
		if (result) {
			return ResponseEntity.status(HttpStatus.CREATED).body(true);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(false);
		}
	}
	
  @PutMapping
  @CrossOrigin
	  @RequestMapping(value="/update") 
	  public Product updateProduct(@RequestBody Product product) { 
	  return service.updateProduct(product); 
	  }  
	  @GetMapping
	 
	  @RequestMapping("/retrieve/{productId}") public Product
	  fetchProduct(@PathVariable long productId) { return
	  service.getProduct(productId); }
	 
	 @DeleteMapping
	 @CrossOrigin
	  @RequestMapping(value="/delete/{productId}")
	 public void deleteProduct(@PathVariable long productId) {
	  service.deleteProduct(productId); }
	 
}