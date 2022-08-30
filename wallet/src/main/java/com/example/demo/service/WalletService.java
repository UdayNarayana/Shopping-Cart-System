package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;



@Service
public class WalletService {
	@Autowired
	private WalletRepository walletRepository;
	
	
	public Wallet addwallet(Wallet wallet) {
		return walletRepository.save(wallet);
		
	}
	public List<Wallet> getWallet() {
		return walletRepository.findAll();
	}
	
	public Wallet getWalletById(int walletid ) {
		return walletRepository.findByWalletid(walletid);
	}
	
	public Wallet updateWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	public String deleteByWalletId(int walletid) {
		walletRepository.deleteById(walletid);
		return "Wallet deleted";
	}
	
	
	


	



}
