package com.eshopping.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshopping.profile.exception.DuplicateUsernameException;
import com.eshopping.profile.exception.InvalidEmailFormatException;
import com.eshopping.profile.exception.InvalidPasswordFormatException;
import com.eshopping.profile.exception.InvalidUsernameFormatException;
import com.eshopping.profile.model.AuthenticationRequest;
import com.eshopping.profile.model.AuthenticationResponse;
import com.eshopping.profile.model.User;
import com.eshopping.profile.repository.UserRepository;
import com.eshopping.profile.util.JwtUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User registerUser(User user) {
		
		if(!user.getEmailId().matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")){
			throw new InvalidEmailFormatException("Invalid email format.");
		}
		
		if(!user.getPassword()
		.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"))
		{
			throw new InvalidPasswordFormatException("Invalid password format.");
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		if(!user.getUsername().matches("^(?=[a-zA-Z0-9._]{3,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")) {
			throw new InvalidUsernameFormatException("Invalid username format.");
		}
		
		User anotherUser = userRepository.findByUsername(user.getUsername());
		
		if(anotherUser!=null) {
			throw new DuplicateUsernameException("Username already exists please try again");
		}
		
		return userRepository.save(user);
	}
	
	public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}

		final UserDetails userDetails = customUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new AuthenticationResponse(jwt);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public String deleteUserByUserId(int userId) {
		userRepository.deleteById(userId);
		return "user profile with ID "+userId+" is deleted.";
	}
	
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "All user profiles are deleted.";
	}
}
