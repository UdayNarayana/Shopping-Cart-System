package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private double price;
	private int quantity;
	private String productType;
	private String description;
	private String image;
	
	public Product(int productId, String productName, double price, int quantity, String productType,
			String description, String image) {
		
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productType = productType;
		this.description = description;
		this.image=image;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getImage() {
		return productId;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product() {
		
	}
	

}
