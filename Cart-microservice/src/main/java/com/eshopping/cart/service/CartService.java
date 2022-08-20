package com.eshopping.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.cart.model.Cart;
import com.eshopping.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
}
