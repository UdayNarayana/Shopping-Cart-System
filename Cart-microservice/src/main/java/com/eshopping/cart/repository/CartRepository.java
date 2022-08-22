package com.eshopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopping.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByCartId(int id);
	
}
