package com.eshopping.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eshopping.cart.model.Items;
import com.eshopping.cart.repository.ItemRepository;
import com.eshopping.cart.service.ItemService;

@SpringBootTest
class CartMicroserviceApplicationTests {

	
	@Autowired
	private ItemService itemService;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	void testGetAllCartItems() {
		Mockito.when(itemRepository.findAll()).thenReturn(Stream.of(
				new Items(1,10,"Google Pixel",60000.0,1),
				new Items(1,20,"Pant",2000.0,1))
				.collect(Collectors.toList()));
		assertEquals(2,itemService.getAllCartItems().size());
	}
	
	@Test
	void testDeleteAllCartItems() {
		assertEquals("All items are deleted", itemService.deleteAllItems());
	}
	
	@Test
	void testAddItemToCart() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		Mockito.when(itemRepository.save(item)).thenReturn(item);
		assertEquals(item, itemService.addItemToCart(item));
	}
	
	@Test
	void testUpdateCartItem() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		assertEquals(itemRepository.saveAndFlush(item), itemService.updateItem(item));
	}

}
