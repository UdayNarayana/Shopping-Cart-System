package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	Product product = new Product();
	
	@GetMapping("/getproducts")
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/getbyid/{productId}")
	public Product getProducts(@PathVariable("productId") int productId){
		return productService.getProductById(productId);
	}
	
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateItem(product);
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public String deleteCartItem(@PathVariable("productId") int productId) {
		return productService.deleteProductById(productId);
	}


}
