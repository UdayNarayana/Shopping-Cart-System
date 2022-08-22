package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Items;
import com.example.demo.repo.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Items> getAllOrderItems() {
		return itemRepository.findAll();
	}
	public Items addItemToOrder(Items item) {
		return itemRepository.save(item);
	}
	
	public Items updateItem(Items item) {
		return itemRepository.saveAndFlush(item);
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
