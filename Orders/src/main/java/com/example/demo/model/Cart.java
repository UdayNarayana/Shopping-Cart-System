package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart {
	public Cart(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;	
	public Cart(int cartId, double totalAmount) {
		super();
		this.cartId = cartId;
		this.totalAmount = totalAmount;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	private double totalAmount;

}
