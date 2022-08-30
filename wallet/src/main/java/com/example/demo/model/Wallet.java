package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
	@Id
	private int walletid;
	private double currentbalance;
	private String transactiontype;
	private int orderid;
	private double amount;
	public int getWalletid() {
		return walletid;
	}
	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}
	public double getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(double currentbalance) {
		this.currentbalance = currentbalance;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Wallet(int walletid, double currentbalance, String transactiontype, int orderid, double amount) {
		
		this.walletid = walletid;
		this.currentbalance = currentbalance;
		this.transactiontype = transactiontype;
		this.orderid = orderid;
		this.amount = amount;
	}
	public Wallet() {
		
	}
	

}
