package com.eshopping.cart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {
	
	private int cartId;
	private List<Items> itemList;
	private double totalAmount;

}
