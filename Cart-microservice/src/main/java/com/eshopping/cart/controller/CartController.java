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
	
	@GetMapping("/get-by-itemId/{itemId}")
	public Items getCartItems(@PathVariable("itemId") int itemId){
		return itemService.getItemByItemId(itemId);
	}
		
	@PostMapping("/add-cart/{cartId}")
	public Cart createNewCart(@PathVariable("cartId") int cartId) {
		cart.setCartId(cartId);
		cart.setTotalAmount(0.0);
		return cartService.createCart(cart);
	}
	
	@PostMapping("/add-items/{itemId}")
	public Items adItemToCart(@RequestBody Items items,
							  @PathVariable("itemId") int itemId) {
		items.setCartId(cart.getCartId());
		items.setItemId(itemId);
		return itemService.addItemToCart(items);
	}
	
	@PutMapping("/update-item")
	public Items updateCartItem(@RequestBody Items item) {
		return itemService.updateItem(item);
	}
	
	@DeleteMapping("/delete-item/{itemId}")
	public String deleteCartItem(@PathVariable("itemId") int itemId) {
		return itemService.deleteItemByitemId(itemId);
	}
	
	
}
