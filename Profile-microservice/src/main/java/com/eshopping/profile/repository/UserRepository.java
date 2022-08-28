package com.eshopping.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopping.profile.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserId(int userId);
	User findByMobileNumber(long mobileNumber);
	User findByFullName(String fullName);
	User findByUsername(String username);
}
