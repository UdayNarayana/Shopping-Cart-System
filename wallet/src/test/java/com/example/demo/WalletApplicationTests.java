package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.WalletService;

@SpringBootTest
class WalletApplicationTests {

	@Test
	void contextLoads() {
		
	}
	@Autowired
	private WalletService walletService;
	
	@MockBean
	private WalletRepository walletRepository;
	
	
	@Test
	void testAddWallet() {
		Wallet wallet =  new Wallet(1, 6000.0, "COD", 101, 300.0);
		Mockito.when(walletRepository.save(wallet)).thenReturn(wallet);
		assertEquals(wallet, walletService.addwallet(wallet));
	}
	
	
	
	@Test
	void testUpdateWallet() {
		Wallet wallet =  new Wallet(1, 6000.0, "COD", 101, 300.0);
		walletRepository.save(wallet);
		wallet.setWalletid(2);
		walletRepository.save(wallet);
		
		assertEquals(2, wallet.getWalletid());
		
		
	}
	
	
	@Test
	void testfindByWalletId() {
		Wallet wallet = new Wallet(1, 6000.0, "COD", 101, 300.0);
		Mockito.when(walletRepository.findByWalletid(1)).thenReturn(wallet);
		assertEquals(wallet, walletService.getWalletById(1));
	}
	
	@Test
	void testdeleteWalletById() {
		Wallet wallet = new Wallet(1, 6000.0, "COD", 101, 300.0);
		assertEquals("Wallet deleted", walletService.deleteByWalletId(1));
	}
	


}
