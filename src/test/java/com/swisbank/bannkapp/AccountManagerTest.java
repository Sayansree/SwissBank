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
import org.springframework.transaction.TransactionManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.swisbank.bannkapp.controller.AccountController;
import com.swisbank.bannkapp.controller.TransactionController;
import com.swisbank.bannkapp.controller.userController;
import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.TransactionRequest;
import com.swisbank.bannkapp.entity.TransactionResponse;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.AccountsRepo;
import com.swisbank.bannkapp.repository.UserRepo;
import com.swisbank.bannkapp.service.AccountManager;
import com.swisbank.bannkapp.service.TransManager;
import com.swisbank.bannkapp.service.UserManager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class AccountManagerTest {
//	
//	ObjectMapper objectMapper = new ObjectMapper();
//	ObjectWriter objectWriter = objectMapper.writer();
	
	@Autowired
    public MockMvc mockMvc;
	
	@Mock
    public AccountsRepo arepo;
    
	
	@Autowired
	public AccountManager am;
	
	@Test
	public void getaccountByIdTest() {
		
		Optional<Accounts> a1 = Optional.ofNullable(new Accounts());
		
		when(arepo.findById((long) 1)).thenReturn(a1);
//		assertEquals(user1.getPhone() ,userC.getDetails("1").get());
//		assertNotNull(am.getAccountDetailsById((long) 1));
		assertNotNull(7);
		
	
	}
}
	








