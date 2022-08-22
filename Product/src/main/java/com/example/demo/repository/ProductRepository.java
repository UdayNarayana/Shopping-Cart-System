package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	Product findByProductName(String productName);
	Product findByCategory(String category);
	Product findByProductType(String productType);
	Product findByProductId(int productId);
	void deleteByProductId(int productId);
	
}
