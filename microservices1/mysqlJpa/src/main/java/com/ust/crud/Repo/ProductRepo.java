package com.ust.crud.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.crud.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> { 

}
