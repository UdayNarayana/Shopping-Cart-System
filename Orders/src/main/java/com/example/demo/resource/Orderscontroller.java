package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Items;
import com.example.demo.model.Orders;
import com.example.demo.service.*;

	@RestController
	@RequestMapping("/orders")
	public class Orderscontroller {
		
		@Autowired
		private OrderService orderService;

		@Autowired
		private ItemService itemService;
		
		Orders order = new Orders();
		
		@GetMapping("/get-items")
		public List<Items> getOrderItems() {
			return itemService.getAllOrderItems();
		}
		@PostMapping("/add-order/{orderId}")
		public Orders createNewOrder(@PathVariable("orderId") int orderId) {
			order.setOrderId(orderId);
			order.setTotalAmount(0.0);
			return orderService.createOrder(order);
		}
		@PostMapping("/add-items/{itemId}")
		public Items adItemToOrder(@RequestBody Items items,
								  @PathVariable("itemId") int itemId) {
			items.setOrderId(order.getOrderId());
			items.setItemId(itemId);
			return itemService.addItemToOrder(items);
		}
		@PutMapping("/update-item")
		public Items updateOrderItem(@RequestBody Items item) {
			return itemService.updateItem(item);
		}
		
		@DeleteMapping("/delete-item/{itemId}")
		public String deleteOrderItem(@PathVariable("itemId") int itemId) {
			return itemService.deleteItemByitemId(itemId);
		}


}
