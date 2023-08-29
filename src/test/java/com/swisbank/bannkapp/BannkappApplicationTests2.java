package com.swisbank.bannkapp;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.swisbank.bannkapp.controller.userController;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.UserRepo;
import com.swisbank.bannkapp.service.UserManager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class userControllerTest {
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Autowired
    public MockMvc mockMvc;
	
	
	@InjectMocks
	public userController userc;

    @Mock
    public UserManager userManager;
    
    public Optional<User> users;
    
    @Autowired
	private UserRepo userData;
    
//    private List<Customer> customers;
	
	@BeforeEach
	public void init() {
		 MockitoAnnotations.openMocks(this);
	     mockMvc = MockMvcBuilders.standaloneSetup(userc).build();
//		 User User1 = new User(  542, "dfgfhj5467u7yh",(long) 1234567891, "gdhds@bdhjvbv", "sneha");
//		 User User2 = new User(  865, "dfgfhj5467u7yh", (long)1234567891, "gdhds@bdhjvbv", "sneha");
//					
//		 User User3 = new User( 55, "dfgfhj5467u7yh", (long)1234567891, "gdhds@bdhjvbv", "sneha");
//		 
//		 List<User> users = Arrays.asList(User1, User2, User3);
	}
	
	


//	@Test
//	public void getDetailsTest() {
//		
//		Optional<User> user1=Optional.ofNullable(new User(1,"ddfgh",(long)4556667,"hbhdfbjbj@gmail.com","dfgh345678"));
//		when(userData.findById((long) 1)).thenReturn(user1);
////		assertEquals(user1.getPhone() ,userC.getDetails("1").get());
//		assertNotNull(userc.getDetails("1"));
//		
//	}
	
	@Test
	public void getUSerTest() {
		User User1 = new User(  542, "dfgfhj5467u7yh",(long) 1234567891, "gdhds@bdhjvbv", "sneha");
		 User User2 = new User(  865, "dfgfhj5467u7yh", (long)1234567891, "gdhds@bdhjvbv", "sneha");
					
		 User User3 = new User( 55, "dfgfhj5467u7yh", (long)1234567891, "gdhds@bdhjvbv", "sneha");
		 
		 List<User> users = Arrays.asList(User1, User2, User3);
			when(userManager.findAll()).thenReturn(users);
			assertEquals(users,  userManager.findAll());
	}
	
//	
//	@Test
//	public void addUserTest() {
//		
//		User user=new User(4456,"ddfgh",(long)4556667,"ftgfg","drcfvg");
//		UserStatus us=new UserStatus(true, 0);
//		when(userData.save(user))
//		.thenReturn(user);
////		
//		assertEquals(us.getErrcode(), userManager.addUser(user).getErrcode() );
////		User res = userData.save(user);
////		assertTrue(user.equals(user));
//		
//
//	}

	}
	








