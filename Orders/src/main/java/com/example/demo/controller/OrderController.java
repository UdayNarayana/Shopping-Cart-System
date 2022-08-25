<<<<<<< HEAD
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

import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/orders")

public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/getall")
	public List<Orders> getAll(){
		return orderService.getAll();

	}
	@PostMapping("/placeorder")
	public Orders placeOrder(@RequestBody Orders order){
		return orderService.placeOrder(order);

	}
	@PutMapping("/updateorder")
	public Orders updateOrder(@RequestBody Orders order){
		return orderService.updateOrder(order);

	}
	@DeleteMapping("/placeorder")
	public String deleteOrder(){
		return orderService.deleteOrder();

	}


}
=======
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

import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;


@RestController
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/getall")
	public List<Orders> getAll(){
		return orderService.getAll();
		
	}
	@PostMapping("/placeorder")
	public Orders placeOrder(@RequestBody Orders order){
		return orderService.placeOrder(order);
		
	}
	@PutMapping("/updateorder")
	public Orders updateOrder(@RequestBody Orders order){
		return orderService.updateOrder(order);
		
	}
	@DeleteMapping("/placeorder")
	public String deleteOrder(){
		return orderService.deleteOrder();
		
	}
	 

}
>>>>>>> f1174f2e153822c7d8115f1eb6f6748dd8545ede
