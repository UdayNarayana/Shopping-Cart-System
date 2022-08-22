package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repo.OrderRepository;
import com.example.demo.model.Orders;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders createOrder(Orders order) {
		return orderRepository.save(order);
	}

}
