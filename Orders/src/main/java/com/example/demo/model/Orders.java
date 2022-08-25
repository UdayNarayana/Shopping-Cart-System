<<<<<<< HEAD
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	private int orderId;
	private int customerId;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;


	public Orders() {

	}
	public Orders(int orderId, int customerId, double amountPaid, String modeOfPayment, String orderStatus,
			int quantity) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
=======
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
	@Id
	private int orderId;
	private int customerId;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;


	public Orders() {
		
	}
	public Orders(int orderId, int customerId, double amountPaid, String modeOfPayment, String orderStatus,
			int quantity) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.amountPaid = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
>>>>>>> f1174f2e153822c7d8115f1eb6f6748dd8545ede
