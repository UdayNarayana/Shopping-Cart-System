package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;

@SpringBootTest
class OrdersApplicationTests {
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;

	@Test
	void testplaceOrder() {
		Orders order =  new Orders(1,10,24.0,"cod","shipping",1);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.placeOrder(order));
		
	}
	@Test
	void testgetallorders() {
		Mockito.when(orderRepository.findAll()).thenReturn(Stream.of(
				new Orders(1,10,24.0,"cod","shipping",1),
				new Orders(1,20,500.0,"e-wallet","placed",5))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAll().size());
	}
	@Test
	void testUpdateOrder() {
		Orders order =  new Orders(1,10,24.0,"cod","shipping",1);
		orderRepository.save(order);
		
		order.setOrderStatus("cancelled");
		orderRepository.save(order);
		
		assertEquals("cancelled", order.getOrderStatus());
	}
	@Test
	void testDeleteAllOrder() {
		assertEquals("orders-deleted", orderService.deleteOrder());
	}

}
