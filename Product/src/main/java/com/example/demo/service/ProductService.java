package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(int productId) {
		return productRepository.findByProductId(productId);
	}
	
	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);
	}
	
	public Product updateProducts(Product product) {
		return productRepository.save(product);
	}

	public String deleteProductById(int productId) {
		productRepository.deleteByProductId(productId);
		return "Product deleted";
	}
	
	public String deleteAllItems() {
		productRepository.deleteAll();
		return "All items are deleted";
	}

	public Product updateItem(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
