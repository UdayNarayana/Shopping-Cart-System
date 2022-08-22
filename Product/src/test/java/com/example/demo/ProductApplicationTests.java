package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@SpringBootTest
class ProductApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	
	@Test
	void testAddProduct() {
		Product product =  new Product(1,"Google Pixel",60000.0,1,"mobile","a mobile");
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProducts(product));
	}
	
	@Test
	void testGetAllProducts() {
		Mockito.when(productRepository.findAll()).thenReturn(Stream.of(
				new Product(1,"Google Pixel",60000.0,1,"mobile","a mobile"),
				new Product(1,"Pant",2000.0,1,"jeans","Jeans"))
				.collect(Collectors.toList()));	
	
		assertEquals(2,productService.getAllProducts().size());
	}
	
	
	@Test
	void testUpdateProduct() {
		Product product =  new Product(1,"Google Pixel",60000.0,1,"mobile","a mobile");
		productRepository.save(product);
		
		product.setProductName("One Plus 10T");
		productRepository.save(product);
		
		assertEquals("One Plus 10T", product.getProductName());
	}
	
	@Test
	void testDeleteAllCartproducts() {
		assertEquals("All products are deleted", productService.deleteAllProducts());
	}

}
