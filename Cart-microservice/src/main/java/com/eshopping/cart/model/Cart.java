package com.eshopping.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {
	
	@Id
	private int cartId;
	private double totalAmount;
	
	public Cart(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
