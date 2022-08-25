<<<<<<< HEAD
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Orders;
@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public List<Orders> getAll() {
		return orderRepository.findAll();
	}
	public Orders placeOrder(Orders order) {
		return orderRepository.save(order);
	}
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}
	public String deleteOrder() {
		 orderRepository.deleteAll();
		 return "orders-deleted";
	}



}
=======
package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Orders;
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	public List<Orders> getAll() {
		return orderRepository.findAll();
	}
	public Orders placeOrder(Orders order) {
		return orderRepository.save(order);
	}
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}
	public String deleteOrder() {
		 orderRepository.deleteAll();
		 return "orders-deleted";
	}



}
>>>>>>> f1174f2e153822c7d8115f1eb6f6748dd8545ede
