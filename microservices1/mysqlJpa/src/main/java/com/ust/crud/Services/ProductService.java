package com.ust.crud.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.crud.Model.Product;
import com.ust.crud.Repo.ProductRepo;



@Service
public class ProductService {
	
	@Autowired
	ProductRepo repository;
	
	
	  public Product getProduct(long productId) { 
		  
	  Optional<Product> optional=repository.findById(productId);
	  if(optional.isPresent())
		  return optional.get();
	  else
		  return null;
	  
	  }
	  
	  public List<Product> getProducts(){
	  return repository.findAll();
	  }
	 
	public boolean add(Product product) {
		repository.save(product);
		return true;
	}
	
	  public Product updateProduct(Product product) {
		  return repository.save(product); } 


public void deleteProduct(long productId) {
	repository.deleteById(productId);
	}
}
