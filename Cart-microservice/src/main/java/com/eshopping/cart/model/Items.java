package com.eshopping.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Items {

	@Id
	private int itemId;
	private int cartId;
	private String productName;
	private double price;
	private int quantity;
	
}
