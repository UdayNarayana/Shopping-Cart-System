package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Orders {
	
	@Id
	private int orderId;
	private int customerId;
	private double amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private LocalDateTime dateTime;
	
}
