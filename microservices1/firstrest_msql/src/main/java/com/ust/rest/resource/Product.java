 // entity helps jpa identify whose class is persistant
package com.ust.rest.resource;

import java.math.BigDecimal; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//generate primary key automatically
	//AUTO is the default generation type or strategy. generation type is the strategy which the JPI should use or follow to generate primary key values
	//when strategy is not specified jpa uses AUTO Strategy. when the underlined database is mysql GenerationType.AUTO means the jpi will create a hibernate sequence in the database for generation of primary keys
	/*
	 * select next_val as id_val from hibernate_sequence for update Hibernate:
	 * update hibernate_sequence set next_val= ? where next_val=? Hibernate: insert
	 * into product (description, name, price, qty, product_id) values (?, ?, ?, ?, ?)
	 */
	//spring.jpa.hibernate.ddl-auto=create   will delete all existing data  so change to null or update
	/* GenerationType.Identity -- for this strategy to work first we have to create  a table in my sql database and explicitly specify the auto increment column as checked for the primary key column and in application.properties file
	 * #spring.jpa.hibernate.ddl-auto=update this should not be set, if it is set it should have value as update */
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private int qty;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
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
