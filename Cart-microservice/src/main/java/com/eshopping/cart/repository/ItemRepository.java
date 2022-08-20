package com.eshopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopping.cart.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {
	
	Items findItemByItemId(int itemId);

}
