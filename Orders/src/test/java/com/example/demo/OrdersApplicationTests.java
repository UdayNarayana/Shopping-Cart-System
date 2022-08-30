package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Orders;
import com.example.demo.service.OrderService;

@SpringBootTest
class OrdersApplicationTests {
	
	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepository;
	
	@MockBean
	private AddressRepository addressRepository;

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
	
		assertEquals(2,orderService.getAllOrders().size());
	}
	@Test
	void testgetallorders1() {
		Mockito.when(orderRepository.findAll()).thenReturn(Stream.of(
				new Orders(1,10,24.0,"cod","shipping",1),
				new Orders(2345,85,753,"e-wallet","cancelled",8))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAllOrders().size());
	}
	@Test
	void testgetallorders2() {
		Mockito.when(orderRepository.findAll()).thenReturn(Stream.of(
				new Orders(1,10,50.0,"e-wallet","shipping",234),
				new Orders(2345,85,753,"e-wallet","cancelled",8))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAllOrders().size());
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
	}
	@Test
	void testDeleteAllOrder() {
		assertEquals("orders-deleted", orderService.deleteOrder());
	}
	@Test
	void testaddAddress() {
		Address address =  new Address(2345,"chetan","9701637322",8,"banglore",560037,"andhra");
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		assertEquals(address, orderService.addAddress(address));
	}
	@Test
	void testgetallAddress() {
		Mockito.when(addressRepository.findAll()).thenReturn(Stream.of(
				new Address(2345,"chetan","9701637322",8,"banglore",560037,"andhra"),
				new Address(2358,"chetan","9701637322",8,"banglore",560037,"andhra"))
				.collect(Collectors.toList()));	
	
		assertEquals(2,orderService.getAllAddress().size());
	}
	@Test
	void testupdateAddress() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		assertEquals(address, orderService.updateAddress(address));
		
	}
	@Test
	void testUpdateAddress1() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setCustomerId(1);
		addressRepository.save(address);
		
		assertEquals(1, address.getCustomerId());
	}
	@Test
	void testUpdateAddress2() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setFullname("reddy");
		addressRepository.save(address);
		
		assertEquals("reddy", address.getFullname());
	}
	@Test
	void testUpdateAddress3() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setMobileNumber("9701659764");
		addressRepository.save(address);
		
		assertEquals("9701659764", address.getMobileNumber());
	}
	@Test
	void testUpdateAddress4() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setFlatNumber(9);
		addressRepository.save(address);
		
		assertEquals(9, address.getFlatNumber());
	}
	@Test
	void testUpdateAddress5() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setCity("nellore");
		addressRepository.save(address);
		
		assertEquals("nellore", address.getCity());
	}
	@Test
	void testUpdateAddress6() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setPincode(560037);
		addressRepository.save(address);
		
		assertEquals(560037, address.getPincode());
	}
	@Test
	void testUpdateAddress7() {
		Address address =  new Address(2345,"chetan","9701638466",8,"banglore",560037,"andhra");
		addressRepository.save(address);
		
		address.setState("telangana");
		addressRepository.save(address);
		
		assertEquals("telangana", address.getState());
	}
	@Test
	void testDeleteAddress() {
		assertEquals("address-deleted", orderService.deleteAddress());
	}

}
