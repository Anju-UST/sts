package com.ust.shopping.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class ProductRequest {
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public ProductRequest() {
		// TODO Auto-generated constructor stub
	}

	public ProductRequest(String name, String description, BigDecimal price) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

	