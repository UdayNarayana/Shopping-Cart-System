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
	void testplaceOrder1() {
		Orders order =  new Orders(1,10,50.0,"e-wallet","shipping",234);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.placeOrder(order));
		
	}
	@Test
	void testplaceOrder2() {
		Orders order =  new Orders(2345,85,753,"cod","placed",8);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.placeOrder(order));
		
	}
	@Test
	void testplaceOrder3() {
		Orders order =  new Orders(2345,85,753,"e-wallet","cancelled",8);
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
	void testgetallorders1() {
		Mockito.when(orderRepository.findAll()).thenReturn(Stream.of(
				new Orders(1,10,24.0,"cod","shipping",1),
				new Orders(2345,85,753,"e-wallet","cancelled",8))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAll().size());
	}
	@Test
	void testgetallorders2() {
		Mockito.when(orderRepository.findAll()).thenReturn(Stream.of(
				new Orders(1,10,50.0,"e-wallet","shipping",234),
				new Orders(2345,85,753,"e-wallet","cancelled",8))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAll().size());
	}
	@Test
	void testupdateOrder3() {
		Orders order =  new Orders(567,85,753,"e-wallet","cancelled",8);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.updateOrder(order));
		
	}
	@Test
	void testUpdateOrder() {
		Orders order =  new Orders(2345,85,753,"e-wallet","cancelled",8);
		orderRepository.save(order);
<<<<<<< HEAD
		
		order.setOrderStatus("placed");
		orderRepository.save(order);
		
		assertEquals("placed", order.getOrderStatus());
	}
	@Test
	void testUpdateOrder1() {
		Orders order =  new Orders(1,10,24.0,"e-wallet","shipping",1);
		orderRepository.save(order);
		
		order.setModeOfPayment("cod");
		orderRepository.save(order);
		
		assertEquals("cod", order.getModeOfPayment());
	}
	@Test
	void testUpdateOrder2() {
		Orders order =  new Orders(1,10,24.0,"e-wallet","shipping",1);
		orderRepository.save(order);
		
		order.setQuantity(5);
		orderRepository.save(order);
		
		assertEquals(5, order.getQuantity());
	}
	@Test
	void testUpdateOrder4() {
		Orders order =  new Orders(1,10,24.0,"e-wallet","shipping",1);
		orderRepository.save(order);
		
		order.setAmountPaid(500.0);
		orderRepository.save(order);
		
		assertEquals(500.0, order.getAmountPaid());
	}
	@Test
	void testUpdateOrder5() {
		Orders order =  new Orders(1,10,24.0,"e-wallet","shipping",1);
		orderRepository.save(order);
		
		order.setCustomerId(534);
		orderRepository.save(order);
		
		assertEquals(534, order.getCustomerId());
	}
	@Test
	void testUpdateOrder6() {
		Orders order =  new Orders(1,10,24.0,"e-wallet","shipping",1);
		orderRepository.save(order);
		
		order.setOrderId(453);
		orderRepository.save(order);
		
		assertEquals(453, order.getOrderId());
=======

		order.setOrderStatus("cancelled");
		orderRepository.save(order);

		assertEquals("cancelled", order.getOrderStatus());
>>>>>>> f1b843612ad7c32f7504669b28fa69ae04dfd44b
	}
	@Test
	void testDeleteAllOrder() {
		assertEquals("orders-deleted", orderService.deleteOrder());
	}

}
