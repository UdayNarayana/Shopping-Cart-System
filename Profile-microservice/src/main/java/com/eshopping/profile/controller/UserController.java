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

import com.eshopping.profile.model.AuthenticationRequest;
import com.eshopping.profile.model.AuthenticationResponse;
import com.eshopping.profile.model.User;
import com.eshopping.profile.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register-user")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse getLoginMessage(@RequestBody AuthenticationRequest authenticationRequest) {
		return userService.login(authenticationRequest);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "<h1>Welcome to EShopping Zone</h1>";
	}
	
	@GetMapping("/get-all-user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/get-user-by-id/{userId}")
	public User getUserByid(@PathVariable("userId") int userId) {
		return userService.getUserByUserId(userId);
	}
	
	@GetMapping("/get-user-by-username/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
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
