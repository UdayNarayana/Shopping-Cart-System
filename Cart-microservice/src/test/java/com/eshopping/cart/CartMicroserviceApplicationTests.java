package com.eshopping.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eshopping.cart.model.Cart;
import com.eshopping.cart.model.Items;
import com.eshopping.cart.repository.CartRepository;
import com.eshopping.cart.repository.ItemRepository;
import com.eshopping.cart.service.CartService;
import com.eshopping.cart.service.ItemService;

@SpringBootTest
class CartMicroserviceApplicationTests {

	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartService cartService;
	
	@MockBean
	private ItemRepository itemRepository;
	
	@MockBean 
	private CartRepository cartRepositroy;
	
	
	@Test
	void testCreateCart() {
		Cart cart = new Cart(1,100.0);
		Mockito.when(cartRepositroy.save(cart)).thenReturn(cart);
		assertEquals(cart,cartService.createCart(cart));
	}
	
	@Test
	void testAddItemToCart() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		Mockito.when(itemRepository.save(item)).thenReturn(item);
		assertEquals(item, itemService.addItemToCart(item));
	}
	
	@Test
	void testGetAllCartItems() {
		Mockito.when(itemRepository.findAll()).thenReturn(Stream.of(
				new Items(1,10,"Google Pixel",60000.0,1),
				new Items(1,20,"Pant",2000.0,1))
				.collect(Collectors.toList()));	
	
		assertEquals(2,itemService.getAllCartItems().size());
	}
	
	@Test
	void testGetItemByItemId() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		Mockito.when(itemRepository.findByItemId(1)).thenReturn(item);
		assertEquals(item,itemService.getItemByItemId(1));
	}
	
	@Test
	void testUpdateCartItem() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		itemRepository.save(item);
		
		item.setProductName("One Plus 10T");
		itemRepository.save(item);
		
		assertEquals("One Plus 10T", item.getProductName());
	}
	
	@Test
	void testDeleteItemByItemId() {
		Items item =  new Items(1,10,"Google Pixel",60000.0,1);
		assertEquals("Item with ID "+item.getItemId()+" is deleted.",
					  itemService.deleteItemByItemId(item.getItemId()));
	}
	
	@Test
	void testDeleteAllCartItems() {
		assertEquals("All items are deleted", itemService.deleteAllItems());
	}

}
