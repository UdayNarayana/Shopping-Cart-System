package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CartItems {

	private int cartId;
	private List<Items> itemList;
	private double totalAmount;
	
	
}
