package com.example.demo.controller;

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

import com.example.demo.model.Wallet;
import com.example.demo.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	
	
	@GetMapping("/getwallet")
	public List<Wallet> getWallet(){
		return walletService.getWallet();
	}
	
	@PostMapping("/addwallet")
	public Wallet addWallet(@RequestBody Wallet wallet) {
		return walletService.addwallet(wallet);
	}
	
	@GetMapping("/getbyid/{walletid}")
	public Wallet getWallet(@PathVariable("walletid") int walletid){
		return walletService.getWalletById(walletid);
	}
	
	@PutMapping("/updatewallet")
	public Wallet updateWallet(@RequestBody Wallet wallet) {
		return walletService.updateWallet(wallet);
	}
	
	@DeleteMapping("/deletewallet/{walletid}")
	public String deleteWallet(@PathVariable("walletid") int walletid) {
		return walletService.deleteByWalletId(walletid);
	}


}
