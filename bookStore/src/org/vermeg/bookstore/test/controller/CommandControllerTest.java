package org.vermeg.bookstore.test.controller;
import static org.hamcrest.Matchers.hasSize;
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
import org.vermeg.bookstore.controller.CommandController;
import org.vermeg.bookstore.model.Command;
import org.vermeg.bookstore.model.User;
import org.vermeg.bookstore.service.CommandService;
class CommandControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private CommandService mockedcommandService;
	@InjectMocks
	private CommandController commandController;
	Command doc1;
	Command doc2;
	User user;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(commandController).build();
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCommands() throws Exception {
		user=new User(1,605245,"hanaa","ab",05);
		doc1=new Command(1,"2020-12-05",user);
		doc2=new Command(2,"2020-12-02",user);
		int iduser = (int) user.getId();
		List <Command>listcommand= new ArrayList<Command>();
		listcommand.add(doc1);
		listcommand.add(doc2);
		when(mockedcommandService.getAllCommands(iduser)).thenReturn(listcommand);
		this.mockMvc.perform(get("/api/documentCommand/getAllCommands/"+iduser))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}

	@Test
	void testGetCommandById() throws Exception {
		user=new User(1,605245,"hanaa","ab",05);
		doc1=new Command(1,"2020-12-05",user);
		int iddoc = (int) doc1.getId();
		when(mockedcommandService.getCommand(iddoc)).thenReturn(doc1);
		this.mockMvc.perform(get("/api/documentCommand/getCommand/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddCommand() throws Exception {
		user=new User(1,605245,"hanaa","ab",05);
		doc1=new Command(1,"2020-12-05",user);
		mockedcommandService.addCommand(doc1);
		verify(mockedcommandService,times(1)).addCommand(doc1);
		this.mockMvc.perform(post("/api/documentCommand/addCommand"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testUpdateCommand() throws Exception {
		user=new User(1,605245,"hanaa","ab",05);
		doc1=new Command(1,"2020-12-05",user);
		int iddoc = (int) doc1.getId();
		mockedcommandService.updateCommand(doc1);
		verify(mockedcommandService,times(1)).updateCommand(doc1);
		this.mockMvc.perform(put("/api/documentCommand/updateCommand/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteCommand() throws Exception {
		user=new User(1,605245,"hanaa","ab",05);
		doc1=new Command(1,"2020-12-05",user);
		int iddoc = (int) doc1.getId();
		mockedcommandService.deleteCommand(iddoc);
		verify(mockedcommandService,times(1)).deleteCommand(iddoc);
		this.mockMvc.perform(delete("/api/documentCommand/deleteCommand/"+iddoc))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
