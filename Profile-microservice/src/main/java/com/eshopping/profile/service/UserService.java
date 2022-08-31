package com.eshopping.profile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eshopping.profile.exception.DuplicateUsernameException;
import com.eshopping.profile.exception.InvalidEmailFormatException;
import com.eshopping.profile.exception.InvalidPasswordFormatException;
import com.eshopping.profile.exception.InvalidUsernameFormatException;
import com.eshopping.profile.model.AuthenticationRequest;
import com.eshopping.profile.model.AuthenticationResponse;
import com.eshopping.profile.model.EmailBody;
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
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String EMAIL_URL = "http://EMAIL-MICROSERVICE/email/send-mail";
	private static final String EMAIL_FORMAT = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
	private static final String PASSWORD_FORMAT = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
	private static final String USERNAME_FORMAT = "^(?=[a-zA-Z0-9._]{3,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public String registerUser(User user) {
		
		if(!user.getEmailId().matches(EMAIL_FORMAT)){
			throw new InvalidEmailFormatException("Invalid email format.");
		}
		
		if(!user.getPassword().matches(PASSWORD_FORMAT)){
			throw new InvalidPasswordFormatException("Invalid password format.");
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		if(!user.getUsername().matches(USERNAME_FORMAT)) {
			throw new InvalidUsernameFormatException("Invalid username format.");
		}
		
		User anotherUser = userRepository.findByUsername(user.getUsername());
		
		if(anotherUser!=null) {
			throw new DuplicateUsernameException("Username already exists please try again");
		}
		
		String username = user.getUsername();
		
		String emailBody = "Dear "+username+",\n\n"+
				  "Welcome to EShopping Zone, you've been successfully registered.\n"+
				  "You can now login and begin shopping at" 
				  + " http://localhost:8020/user/welcome\n\n"+
				  "Thank you,\n"+
				  "EShopping Zone";
		
		String emailSubject = "Account Registration Confirmation";
		
		EmailBody mail = new EmailBody(
				user.getUsername(),
				user.getEmailId(),
				emailSubject, 
				emailBody
				);
		
		userRepository.save(user);
		
	    restTemplate.postForObject(EMAIL_URL, mail, String.class);
		 
		return "User successfully registered";
		
	}
	
	public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), 
							authenticationRequest.getPassword()
							)
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
