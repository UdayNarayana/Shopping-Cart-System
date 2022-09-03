package com.example.demo.model;

import java.util.List;

public class CartItems {
	public CartItems() {
		
	}
	private int cartId;
	private List<Items> itemList;
	private double totalAmount;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public CartItems(int cartId, List<Items> itemList, double totalAmount) {
		super();
		this.cartId = cartId;
		this.itemList = itemList;
		this.totalAmount = totalAmount;
	}
	
	
}
