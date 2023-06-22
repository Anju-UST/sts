package com.example.demo.services;

import java.util.List;

import com.example.demo.resource.Product;

public interface ProductServiceIface {
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);
}
