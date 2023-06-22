package com.ust.shopping.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.shopping.dto.ProductRequest;
import com.ust.shopping.model.Product;
import com.ust.shopping.repo.ProductRepository;

@Service
public class ProductService {
	@Autowired 
	ProductRepository repo;
	
	public Product createProduct(@Valid ProductRequest request ){
		Product product =new Product(request.getId(),request.getName(),request.getDescription(),request.getPrice());
		return repo.save(product);
	}

}
