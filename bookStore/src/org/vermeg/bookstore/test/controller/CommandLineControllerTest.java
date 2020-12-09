package org.vermeg.bookstore.test.controller;

import static org.hamcrest.Matchers.hasSize;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.model.User;
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
import org.vermeg.bookstore.service.CommandLineService;
import java.util.ArrayList;
import java.util.List;

import org.vermeg.bookstore.model.Command;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
import org.vermeg.bookstore.controller.CommandLineController;
import org.vermeg.bookstore.model.CommandLine;

class CommandLineControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private CommandLineService mockedCommandLineService;
	@InjectMocks
	private CommandLineController commandlineController;
	CommandLine commandline;
	CommandLine commandline1;
	Book book;
	Command command;
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
		this.mockMvc = MockMvcBuilders.standaloneSetup(commandlineController).build();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCommandLines() throws Exception {
		user=new User(1,5,"r","y",22);
		book=new Book(1,10001,"a","b","2020-11-12","b",100);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book ,command);
		commandline1 = new CommandLine(2,20,book,command);
		int orderid=(int) command.getId();
		List <CommandLine>listcl= new ArrayList<CommandLine>();
		listcl.add(commandline);
		listcl.add(commandline1);
		when(mockedCommandLineService.getAllCommandLines(orderid)).thenReturn(listcl);
		this.mockMvc.perform(get("/api/cl/getAllCommandLines/"+orderid))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}
	

	@Test
	void testGetCommandLineById() throws Exception {
		user=new User(1,75,"r","y",122);
		book=new Book(1,10001,"a","b","2020-11-12","b",100);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		int clid=(int) commandline.getNumLigne();
		when(mockedCommandLineService.getCommandLine(clid)).thenReturn(commandline);
		this.mockMvc.perform(get("/api/commandline/getCommandLine/"+clid))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddCommandLine() throws Exception {
		user=new User(1,5,"rrrr","tyy",220);
		book=new Book(1,10001,"a","b","2020-11-12","b",100);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		mockedCommandLineService.addCommandLine(commandline);
		verify(mockedCommandLineService,times(1)).addCommandLine(commandline);
		this.mockMvc.perform(post("/api/commandline/addCommandLine"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testUpdateCommandLine() throws Exception {
		user=new User(1,7875,"r","tyy",022);
		book=new Book(1,10001,"a","b","2020-11-12","b",100);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		mockedCommandLineService.updateCommandLine(commandline);
		int clid=(int) commandline.getNumLigne();
		verify(mockedCommandLineService,times(1)).updateCommandLine(commandline);
		this.mockMvc.perform(put("/api/commandline/updateCommandLine/"+clid))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testDeleteCommandLine() throws Exception {
		user=new User(1,699875,"rr","yy",22);
		book=new Book(1,10001,"aaa","eee","2020-01-12","vvvbbb",1500);
		command = new Command(1,"2020-12-15",user);
		commandline = new CommandLine(1,15,book,command);
		int clid=(int) commandline.getNumLigne();
		mockedCommandLineService.deleteCommandLine(clid);;
		verify(mockedCommandLineService,times(1)).deleteCommandLine(clid);
		this.mockMvc.perform(delete("/api/commandline/deleteCommandline/"+clid))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

}
