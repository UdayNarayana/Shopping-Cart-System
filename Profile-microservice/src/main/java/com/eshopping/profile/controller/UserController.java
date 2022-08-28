package com.eshopping.profile.controller;

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

import com.eshopping.profile.model.User;
import com.eshopping.profile.repository.UserRepository;
import com.eshopping.profile.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/register-user")
	public User registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@GetMapping("/login")
	public String getLoginMessage() {
		return "Successfully logged in!";
	}
	
	@GetMapping("/get-username/{username}")
	public String getByUsername(@PathVariable("username") String username) {
		 User user = userRepository.findByUsername(username);
		 return user.getPassword();
	}
	
	@GetMapping("/get-all-user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/get-user-by-id/{userId}")
	public User getUserByid(@PathVariable("userId") int userId) {
		return userService.getUserByUserId(userId);
	}
	
	@GetMapping("/get-user-by-mobileNumber/{mobileNumber}")
	public User getUserByNumber(@PathVariable("mobileNumber") long mobileNumber) {
		return userService.getUserByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/get-users-by-fullName/{fullName}")
	public User getUserByFullName(@PathVariable("fullName") String fullName){
		return userService.getUserByFullName(fullName);
	}
	
	@PutMapping("/update-user")
	public User updateUserDetails(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete-by-userId/{userId}")
	public String deleteUserById(@PathVariable("userId") int userId) {
		return userService.deleteUserByUserId(userId);
	}
	
	@DeleteMapping("/delete-users")
	public String deleteAllUser() {
		return userService.deleteAllUsers();
	}
}
