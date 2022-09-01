package com.example.demo.service;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Orders;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	AddressRepository addressRepository;

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}
	public List<Address> getAllOrderAddress() {
		return addressRepository.findAll();
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
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}
	public String deleteAddress() {
		addressRepository.deleteAll();
		 return "address-deleted";
	}



}
