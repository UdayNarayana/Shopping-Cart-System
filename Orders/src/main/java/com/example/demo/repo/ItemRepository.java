package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Items;


public interface ItemRepository extends JpaRepository<Items, Integer>{
	Items findItemByItemId(int itemId);


}
