package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	Orders findByOrderId(int id);

}
