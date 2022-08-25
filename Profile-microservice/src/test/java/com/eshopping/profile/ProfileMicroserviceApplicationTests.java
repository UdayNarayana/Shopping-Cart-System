package com.eshopping.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eshopping.profile.model.User;
import com.eshopping.profile.repository.UserRepository;
import com.eshopping.profile.service.UserService;

@SpringBootTest
class ProfileMicroserviceApplicationTests {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	void testRegisterUser() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.registerUser(user));
	}
	
	@Test
	void testSetRegisterUser() {
		User user = new User();
		
		user.setUserId(1);
		user.setFullName("test name");
		user.setImage("http://sample-image");
		user.setEmailId("test@mail.com");
		user.setPassword("test");
		user.setMobileNumber(1111111111);
		user.setAddress("test address");
		user.setAbout("test about");
		user.setDob("21-08-2022");
		user.setGender("male");
		user.setRole("customer");
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.registerUser(user));
	}
	
	@Test
	void testGetAllUsers() {
		Mockito.when(userRepository.findAll()).thenReturn(Stream.of(
				new User(
						1,
						"test name",
						"http://sample-image",
						"test@mail.com",
						"test",
						1111111111,
						"test address",
						"test about",
						"21-08-2022",
						"male",
						"customer"),
				new User(
						2,
						"test name2",
						"http://sample-image2",
						"test2@mail.com",
						"test2",
						1111111112,
						"test address2",
						"test about2",
						"22-08-2022",
						"female",
						"merchant"))
				.collect(Collectors.toList()));	
	
		assertEquals(2,userService.getAllUsers().size());
	}

	@Test
	void testGetUserByUserId() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		User anotherUser = new User(
				2,
				"test name",
				user.getImage(),
				user.getEmailId(),
				user.getPassword(),
				1111111111,
				user.getAddress(),
				user.getAbout(),
				user.getDob(),
				user.getGender(),
				user.getRole()
				);
		Mockito.when(userRepository.findByUserId(2)).thenReturn(anotherUser);
		assertEquals(anotherUser, userService.getUserByUserId(2));
	}
	
	@Test
	void testGetUserByMobileNumber() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		Mockito.when(userRepository.findByMobileNumber(1111111111)).thenReturn(user);
		assertEquals(user, userService.getUserByMobileNumber(user.getMobileNumber()));
	}
	
	@Test
	void testGetUsersByFullName() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		Mockito.when(userRepository.findByFullName("test name")).thenReturn(user);
		assertEquals(user, userService.getUserByFullName("test name"));
	}
	
	@Test
	void testUpdateUser() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		user.setFullName("test name1");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals("test name1", user.getFullName());	
	}
	
	@Test
	void testDeleteUserByid() {
		User user = new User(
				1,
				"test name",
				"http://sample-image",
				"test@mail.com",
				"test",
				1111111111,
				"test address",
				"test about",
				"21-08-2022",
				"male",
				"customer");
		assertEquals("user profile with ID "+user.getUserId()+" is deleted.",
					 userService.deleteUserByUserId(1));
	}
	
	@Test 
	void testDeleteAllUsers(){
		assertEquals("All user profiles are deleted.", userService.deleteAllUsers());
	}
}
