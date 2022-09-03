package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.MessagingConfig;
import com.example.demo.model.Address;
import com.example.demo.model.CartItems;
import com.example.demo.model.OrderAddresses;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;






@RestController
@RequestMapping("/orders")


public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	RestTemplate restTemplate;
	
	 @Autowired
	  private RabbitTemplate template;
	 
	 
	
	@GetMapping("/getallorders")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	@GetMapping("/getalladdress")
	public List<Address> getAllAddress(){
		return orderService.getAllAddress();
		
	}
	@GetMapping("/getaddress")
		public OrderAddresses getAllOrderAddress(){
		Orders orders = new Orders();
			return new OrderAddresses(orders.getCustomerId(), 
								 orderService.getAllOrderAddress());
		}
	@PostMapping("/placeorder")
	public Orders placeOrder(@RequestBody Orders order){
		CartItems cartItems = restTemplate.getForObject("http://localhost:8081/cart/view-all-items", CartItems.class);
		order.setAmountPaid(cartItems.getTotalAmount());
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
	@PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Orders order, @PathVariable String restaurantName) {
        order.setOrderStatus(UUID.randomUUID().toString());
        //restaurantservice
        //payment service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
	 

}
