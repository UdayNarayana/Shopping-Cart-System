package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Items {
	public Items() {
		
	}

	@Id
	private int itemId;
	private int cartId;
	private String productName;
	private double price;
	private int quantity;
	public Items(int itemId, int cartId, String productName, double price, int quantity) {
		super();
		this.itemId = itemId;
		this.cartId = cartId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
}
