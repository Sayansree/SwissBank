package com.swisbank.bannkapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.when;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.swisbank.bannkapp.controller.userController;
import com.swisbank.bannkapp.entity.AuthReq;
import com.swisbank.bannkapp.entity.AuthStatus;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.UserRepo;
import com.swisbank.bannkapp.service.TransManager;
import com.swisbank.bannkapp.service.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BannkappApplicationTests {
	
	@MockBean
	private UserRepo userData;
	
	@Autowired
	UserManager um;

	@Autowired
	userController userC;
//	@Autowired
//	UserStatus us;
//
//	@Autowired
//	User user;
//	
	@Test
	public void getAllUsersTest() {
		String emailString = "email";
		
		//Mock database
		when(userData.findByEmail(emailString))
		.thenReturn(
				Stream.of(new User())
				.collect(Collectors.toList()));
		
		assertEquals(true, um.emailExists(emailString));
		
	}
	
//	@Test
//	public void getUsersTest() {
//		
//		assertEquals(1, 1);
//	}
	
	
	@Test
	public void addUserTest() {
		
		User user=new User(4456,"ddfgh",(long)4556667,"ftgfg","drcfvg");
		UserStatus us=new UserStatus(true, 0);
		when(userData.save(user))
		.thenReturn(user);
//		
		assertEquals(us.getErrcode(), um.addUser(user).getErrcode() );
//		User res = userData.save(user);
//		assertTrue(user.equals(user));
	}
	
//	Controller test
	@Test
	public void registerTest()
	{
		User user=new User(4456,"ddfgh",(long)4556667,"ftgfg","drcfvg");

		UserStatus us=new UserStatus(true, 0);
		
//		when(um.addUser(user)).thenReturn(us);
		when(um.addUser(user))
		.thenReturn(us);
		assertEquals( us.getErrcode(), userC.register(user).getErrcode() );
		
		
	}
	
//	
//	public void getDetailsTest() {
//		
//		
//		when(null)
//		
//		assertEquals(0, userC.getDetails(authReq));
//		
//		
//	}
	@Test
	public void loginTest() {
		
		AuthReq authReq = new AuthReq("hbhdfbjbj@gmail.com", "dfgh345678");
		User user1=new User(4456,"ddfgh",(long)4556667,"hbhdfbjbj@gmail.com","dfgh345678");
		User user2=new User(4457,"dfgvbn",(long)4556467,"hbhdfbjbj@gmail.com","dfgh345678");
		AuthStatus aStatus=new AuthStatus(true,0, (long) 45678.67);
		
		ArrayList<User> lst = new ArrayList<User>(2);
		lst.add(user1);
		lst.add(user2);
		when(userData.findByEmail("hbhdfbjbj@gmail.com")).thenReturn(lst);
		
		
		assertEquals(aStatus.getErrcode(), userC.login(authReq).getErrcode());
	}
	
//	Service test
	@Test
	public void getDetailsTest() {
		
		Optional<User> user1= Optional.ofNullable(new User(1,"ddfgh",(long)4556667,"hbhdfbjbj@gmail.com","dfgh345678"));
		when(userData.findById((long) 1)).thenReturn(user1);
//		assertEquals(user1.getPhone() ,userC.getDetails("1").get());
		assertNotNull(user1);
		
	}
	 
	public void deleteTest() {
	
	}

	
	
}
