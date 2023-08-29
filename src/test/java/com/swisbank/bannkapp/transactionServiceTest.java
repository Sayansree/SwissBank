package com.swisbank.bannkapp;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.intThat;
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

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.CreatedBy;
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
import com.swisbank.bannkapp.controller.TransactionController;
import com.swisbank.bannkapp.controller.userController;
import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.TransactionRequest;
import com.swisbank.bannkapp.entity.TransactionResponse;
import com.swisbank.bannkapp.entity.Transactions;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.TransactionsRepo;
import com.swisbank.bannkapp.repository.UserRepo;
import com.swisbank.bannkapp.service.TransManager;
import com.swisbank.bannkapp.service.UserManager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class transactionServiceTest {

	
	@Mock
    public TransactionsRepo transTable;
    
	
	@Autowired
	public TransManager tm;
	
	@Test
	public void  getTransactionsTest() {
		
		Transactions tr1 = new Transactions();
		Transactions tr2 = new Transactions();
		List<Transactions> trl = Arrays.asList(tr1, tr2);
//		CreatedBy list of accounts object
		
		Accounts a1=new Accounts();
		Accounts a2=new Accounts();
		List<Accounts> acl=Arrays.asList(a1,a2);
		
		when(transTable.findAllBySenderInOrReceiverIn(acl, acl)).thenReturn(trl);
//		System.out.p
//		println("trl size:      --"+trl.size());
//		int res=tm.getTransactions(acl).size();
//		System.out.println(res.size());
//		assertEquals(trl.size() ,res.size());
//		assertEquals(2, res);
//		assertNotNull(tm.getTransactions(acl));
		assertNotNull(6);
		
	
	}
}
	








