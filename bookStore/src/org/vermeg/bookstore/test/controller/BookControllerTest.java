package org.vermeg.bookstore.test.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
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
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.vermeg.bookstore.controller.CommandLineController;
import org.vermeg.bookstore.controller.BookController;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.service.CommandLineService;
import org.vermeg.bookstore.service.BookService;

public class BookControllerTest {
@Autowired
private MockMvc mockMvc;
@Mock
private BookService mockedBookkService;
@InjectMocks
private BookController bookController;
Book b;
Book b1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBooks() throws Exception {
		b=new Book(011, 1100, "book11", "author1", "2020-11-14", "d1", 12000);
		b1=new Book(021, 1200, "book21", "author2", "2020-01-15", "d2", 18000);
		List<Book>listofbooks=new ArrayList<Book>();
		listofbooks.add(b);
		listofbooks.add(b1);
		when(mockedBookkService.getAllBooks()).thenReturn(listofbooks);
		this.mockMvc.perform(get("/api/book/getAllBooks"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2)))
		.andDo(print());
	}

	@Test
	public void testGetBookById() throws Exception{
		b=new Book(011, 1100, "book11", "author1", "2020-11-14", "d1", 12000);
		int idb=b.getId();
		when(mockedBookkService.getBook(idb)).thenReturn(b);
		this.mockMvc.perform(get("/api/book/getBook/"+idb))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testAddLivre() throws Exception {
		b=new Book(011, 1100, "book11", "author1", "2020-11-14", "d1", 12000);
		mockedBookkService.addBook(b);
		verify(mockedBookkService,times(1)).addBook(b);
		this.mockMvc.perform(post("/api/book/addBook"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void testUpdateLivre() throws Exception{
		b=new Book(011, 1100, "book11", "author1", "2020-11-14", "d1", 12000);
		int idb=b.getId();
		mockedBookkService.updateBook(b);
		verify(mockedBookkService,times(1)).updateBook(b);
		this.mockMvc.perform(put("/api/book/updateBook/"+idb))
		.andExpect(status().isOk())
		.andDo(print());
	
	}

	@Test
	public void testDeleteLivre() throws Exception {
		b=new Book(011, 1100, "book11", "author1", "2020-11-14", "d1", 12000);
		int idb=b.getId();
		mockedBookkService.deleteBook(idb);
		verify(mockedBookkService,times(1)).deleteBook(idb);
		this.mockMvc.perform(delete("/api/livre/deleteLivre/"+idb))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

}
