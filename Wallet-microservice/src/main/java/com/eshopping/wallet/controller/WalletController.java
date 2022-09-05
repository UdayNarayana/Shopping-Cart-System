package com.eshopping.wallet.controller;

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

import com.eshopping.wallet.model.Wallet;
import com.eshopping.wallet.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@PostMapping("/create-wallet")
	public Wallet addWallet(@RequestBody Wallet wallet) {
		return walletService.createWallet(wallet);
	}
	
	@GetMapping("/get-wallet-by-walletId/{walletId}")
	public Wallet getWalletById(@PathVariable("walletId") int walletId) {
		return walletService.getWalletByWalletId(walletId);
	}
	
	@GetMapping("/get-wallet-by-userId/{userId}")
	public Wallet getWalletByUserId(@PathVariable("userId") int userId) {
		return walletService.getWalletByUserId(userId);
	}
	
	@GetMapping("/get-wallets")
	public List<Wallet> getAllWallets(){
		return walletService.getAllWallets();
	}
	
	@PutMapping("/add-money-to-wallet")
	public Wallet updateWallet(@RequestBody Wallet wallet) {
		return walletService.addMoneyToWallet(wallet);
	}
	
	@DeleteMapping("/delete-by-walletId/{walletId}")
	public String deleteWalletById(@PathVariable("walletId") int walletId) {
		return walletService.deleteWalletByWalletId(walletId);
	}
	
	@DeleteMapping("/delete-wallets")
	public String deleteAllWallets() {
		return walletService.deleteAllWallets();
	}
	
}
