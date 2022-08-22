package com.eshopping.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.cart.model.Items;
import com.eshopping.cart.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Items> getAllCartItems() {
		return itemRepository.findAll();
	}
	
	public Items getItemByItemId(int itemId) {
		return itemRepository.findByItemId(itemId);
	}
	
	public Items addItemToCart(Items item) {
		return itemRepository.save(item);
	}
	
	public Items updateItem(Items item) {
		return itemRepository.save(item);
	}

	public String deleteItemByitemId(int itemId) {
		itemRepository.deleteById(itemId);
		return "Item deleted";
	}
	
	public String deleteAllItems() {
		itemRepository.deleteAll();
		return "All items are deleted";
	}
}
