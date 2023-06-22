package com.example.demo.resource;

import java.math.BigDecimal;

public class Product {
	Integer productId;
	String Name;
	String Category;
	String brand;
	double price;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(Integer productId, String name, String category, String brand, double price) {
		super();
		this.productId = productId;
		Name = name;
		Category = category;
		this.brand = brand;
		this.price = price;
	}
	
	
}
