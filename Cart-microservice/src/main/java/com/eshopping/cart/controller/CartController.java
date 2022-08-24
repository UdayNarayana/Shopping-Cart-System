package com.eshopping.cart.controller;

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

import com.eshopping.cart.model.Cart;
import com.eshopping.cart.model.CartItems;
import com.eshopping.cart.model.Items;
import com.eshopping.cart.service.CartService;
import com.eshopping.cart.service.ItemService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ItemService itemService;
	
	Cart cart = new Cart();
	
	@GetMapping("/get-items")
	public List<Items> getCartItems(){
		return itemService.getAllCartItems();
	}
		
	@GetMapping("/get-item-by-id/{itemId}")
	public Items getItemById(@PathVariable("itemId")int itemId) {
		return itemService.getItemByItemId(itemId);
	}
	
	@GetMapping("/view-all-items")
	public CartItems getAllCartItems(){
		return new CartItems(cart.getCartId(), 
							 itemService.getAllCartItems() , 
							 cartService.getTotalAmount());
	}
	
	@PostMapping("/create-cart/{cartId}")
	public Cart createNewCart(@PathVariable("cartId") int cartId) {
		cart.setCartId(cartId);
		cart.setTotalAmount(cartService.getTotalAmount());
		return cartService.createCart(cart);
	}
	
	@PostMapping("/add-items/{itemId}")
	public Items addItemToCart(@RequestBody Items items,
							  @PathVariable("itemId") int itemId) {
		items.setCartId(cart.getCartId());
		items.setItemId(itemId);
		return itemService.addItemToCart(items);
	}
	
	@PutMapping("/update-item")
	public Items updateCartItem(@RequestBody Items item) {
		return itemService.updateItem(item);
	}
	
	@DeleteMapping("/delete-item-by-id/{itemId}")
	public String deleteItemById(@PathVariable("itemId") int itemId) {
		return itemService.deleteItemByItemId(itemId);
	}
	
	@DeleteMapping("/delete-items")
	public String deleteCartItems() {
		return itemService.deleteAllItems();
	}
	
	
}
