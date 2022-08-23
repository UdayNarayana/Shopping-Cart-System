package com.eshopping.cart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {
	
	private int cartId;
	private List<Items> itemList;
	private double totalAmount;

}
