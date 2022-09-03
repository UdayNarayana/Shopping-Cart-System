package com.example.demo.model;

import java.util.List;

public class OrderAddresses {
	public OrderAddresses() {
		
	}
	public OrderAddresses(int customerId, List<Address> addressList) {
		super();
		CustomerId = customerId;
		this.addressList = addressList;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	private int CustomerId;
	private List<Address> addressList;
	

}
