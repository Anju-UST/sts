package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.Product;
import com.example.demo.services.ProductServiceIface;

@RestController
@RequestMapping("/product-service")
public class ProductControler {
	
	@Autowired
	ProductServiceIface product;
	
	@GetMapping("/products")
	public List<Product> findAll(){
		
		return product.findAll();
	}
	@GetMapping("/products-by-category/{category}")
	public List<Product> findByCategory(@PathVariable("category") String category){
		return product.findByCategory(category);
		
	}
	@GetMapping("/products-by-id/{id}")
	public Product findById(@PathVariable("id") int id) {
		return product.findById(id);
		
	}

}