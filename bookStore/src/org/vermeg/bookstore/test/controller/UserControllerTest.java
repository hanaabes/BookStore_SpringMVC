package org.vermeg.bookstore.test.controller;
import static org.hamcrest.Matchers.hasSize;

import org.vermeg.bookstore.service.UserService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.vermeg.bookstore.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.controller.UserController;
class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private UserService mockedUserService;
	@InjectMocks
	private UserController userController;
	User user1;
	User user2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsers() throws Exception {
		user1=new User(1,056,"hana","abbes",211);
		user2=new User(2,055,"abbes","hana",300);
		List <User>listusers= new ArrayList<User>();
		listusers.add(user1);
		listusers.add(user2);
		when(mockedUserService.getAllUsers()).thenReturn(listusers);
		this.mockMvc.perform(get("/api/User/getAllUsers")).andExpect(status().isOk()).andExpect(jsonPath("$",hasSize(2))).andDo(print());
	}

	@Test
	void testGetUserById() throws Exception {
		user1=new User(1,6991245,"hana","hana",23);
		int iduser = (int) user1.getId();
		when(mockedUserService.getUser(iduser)).thenReturn(user1);
		this.mockMvc.perform(get("/api/User/getUser/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());	
	}

	@Test
	void testAddUser() throws Exception {
		user1=new User(1,697,"hana","hana",223);
		mockedUserService.addUser(user1);
		verify(mockedUserService,times(1)).addUser(user1);
		this.mockMvc.perform(post("/api/User/addUser"))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	void testUpdateUser() throws Exception {
		user1=new User(1,245,"hana","hana",273);
		long iduser = user1.getId();
		mockedUserService.updateUser(user1);
		verify(mockedUserService,times(1)).updateUser(user1);
		this.mockMvc.perform(put("/api/User/updateUser/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteUser() throws Exception {
		user1=new User(1,65,"hana","hana",213);
		long iduser = user1.getId();
		mockedUserService.deleteUser((int) iduser);
		verify(mockedUserService,times(1)).deleteUser((int) iduser);
		this.mockMvc.perform(delete("/api/User/deleteUser/"+iduser))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
