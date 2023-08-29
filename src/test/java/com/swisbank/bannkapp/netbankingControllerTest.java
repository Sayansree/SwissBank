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
import com.swisbank.bannkapp.controller.NetBankingController;
import com.swisbank.bannkapp.controller.TransactionController;
import com.swisbank.bannkapp.controller.userController;
import com.swisbank.bannkapp.entity.NetBankingChange;
import com.swisbank.bannkapp.entity.TransactionRequest;
import com.swisbank.bannkapp.entity.TransactionResponse;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.UserRepo;
import com.swisbank.bannkapp.service.NetBankingManager;
import com.swisbank.bannkapp.service.TransManager;
import com.swisbank.bannkapp.service.UserManager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class netbankingControllerTest {
//	
//	ObjectMapper objectMapper = new ObjectMapper();
//	ObjectWriter objectWriter = objectMapper.writer();
	
	@Autowired
    public NetBankingController netcontroller;
	
	@Mock
    public NetBankingManager nbm;
    
	
	@Autowired
	public TransactionController tc;
	
	@Test
	public void changePasswordTest() {
		
		NetBankingChange nbc = new NetBankingChange("dfghj","dfghj",(long)9);
		
		TransactionRequest tr=new TransactionRequest();
		when(nbm.updateNB(nbc.getAid(),nbc.getOld_pass(),nbc.getNew_pass())).thenReturn(8);
//		assertEquals(user1.getPhone() ,userC.getDetails("1").get());
		assertNotNull(netcontroller.changePassword(nbc));
		
	
	}
}
	








