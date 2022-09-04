package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.config.MQConfig;
import com.example.demo.exception.InsufficientWalletFundsException;
import com.example.demo.model.Address;
import com.example.demo.model.CartItems;
import com.example.demo.model.EmailBody;
import com.example.demo.model.OrderAddresses;
import com.example.demo.model.Orders;
import com.example.demo.model.User;
import com.example.demo.model.Wallet;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RabbitTemplate template;
	
//	@Autowired
//	private AddressRepository addressRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}
	
//	public List<Address> getAllOrderAddress() {
//		return addressRepository.findAll();
//	}
	
	public OrderAddresses placeOrder(Orders order,int addressId) {
		CartItems cartItems = restTemplate.getForObject("http://CART-MICROSERVICE/cart/view-all-items", CartItems.class);
		order.setAmountPaid(cartItems.getTotalAmount());
		
		if(order.getModeOfPayment().equals("e-wallet")) {
			
			Wallet wallet = restTemplate.getForObject("http://WALLET-MICROSERVICE/wallet/get-wallet-by-userId/"+order.getCustomerId(), Wallet.class);
			
			if(order.getAmountPaid() > wallet.getCurrentBalance()) {
				throw new InsufficientWalletFundsException("Please add more money to place the order.");
			}
			
			wallet.setCurrentBalance(wallet.getCurrentBalance()-order.getAmountPaid());
			restTemplate.put("http://WALLET-MICROSERVICE/wallet/add-money-to-wallet", wallet);
		}
		List<Address> addressList = restTemplate.getForObject("http://PROFILE-MICROSERVICE/user/get-address-by-userId/"+order.getCustomerId(), List.class);
		
		order.setDateTime(LocalDateTime.now());
		order.setOrderStatus("Paid");
		
		orderRepository.save(order);
		
		User user = restTemplate.getForObject("http://PROFILE-MICROSERVICE/user/get-user-by-id/"+order.getCustomerId(), User.class);
		
		String username = user.getUsername();
		
		String paymentMode = order.getModeOfPayment();
		
		String emailBody = "Dear "+username+",\n\n"+
				  "Your order has been successfully placed with payment mode "+paymentMode+
				  ".\n" 
				  + "You order will be delivered to you in 3-4 buisness days.\n"+
				  "Continue shopping at http://localhost:8084/orders/shop.\n\n"+
				  "Thank you,\n"+
				  "EShopping Zone";
		
		String emailSubject = "Order Confirmation";
		
		EmailBody mail = new EmailBody(
				user.getUsername(),
				user.getEmailId(),
				emailSubject, 
				emailBody
				);
		
//		restTemplate.postForObject("http://EMAIL-MICROSERVICE/email/send-mail", mail, String.class);
		
		template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, mail);
		
		return new OrderAddresses(order,addressList);
	
	}
	
	public Orders updateOrder(Orders order) {
		return orderRepository.save(order);
	}
	
	public String deleteOrder() {
		 orderRepository.deleteAll();
		 return "orders-deleted";
	}
	
//	public List<Address> getAllAddress() {
//		return addressRepository.findAll();
//	}
//	
//	public Address addAddress(Address address) {
//		return addressRepository.save(address);
//	}
//	
//	public Address updateAddress(Address address) {
//		return addressRepository.save(address);
//	}
//	
//	public String deleteAddress() {
//		addressRepository.deleteAll();
//		 return "address-deleted";
//	}



}
