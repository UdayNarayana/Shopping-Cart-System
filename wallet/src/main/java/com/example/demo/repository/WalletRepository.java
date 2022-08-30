package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	Wallet findByWalletid(int walletid );
	Wallet findByTransactiontype(String transactiontype);
	Wallet findByOrderid(int orderid);

}
