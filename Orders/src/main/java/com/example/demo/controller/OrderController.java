package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/getallorders")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	@GetMapping("/getalladdress")
	public List<Address> getAllAddress(){
		return orderService.getAllAddress();
		
	}
	@PostMapping("/placeorder")
	public Orders placeOrder(@RequestBody Orders order){
		return orderService.placeOrder(order);
		
	}
	@PutMapping("/updateorder")
	public Orders updateOrder(@RequestBody Orders order){
		return orderService.updateOrder(order);
		
	}
	@DeleteMapping("/deleteorder")
	public String deleteOrder(){
		return orderService.deleteOrder();
		
	}
	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody Address address){
		return orderService.addAddress(address);
		
	}
	@PutMapping("/updateAddress")
	public Address updateAddress(@RequestBody Address address){
		return orderService.updateAddress(address);
		
	}
	@DeleteMapping("/deleteAddress")
	public String deleteAddress(){
		return orderService.deleteAddress();
		
	}
	 

}
