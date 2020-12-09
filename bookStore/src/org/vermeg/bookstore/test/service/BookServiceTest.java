package org.vermeg.bookstore.test.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vermeg.bookstore.interfaces.BookInterface;
import org.vermeg.bookstore.model.CommandLine;
import org.vermeg.bookstore.model.Book;
class BookServiceTest {
	Book Book;
	Book Book1;
	BookInterface BookInterface = mock(BookInterface.class);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllBooks() {
		Book=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		Book1=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		List <Book>listBook= new ArrayList<Book>();
		listBook.add(Book);
		listBook.add(Book1);
		when(org.vermeg.bookstore.interfaces.BookInterface.getAllBooks()).thenReturn(listBook);
		assertEquals(Book,listBook.get(0) ,"  Book différent");
		assertEquals(Book1,listBook.get(1),"  Book différent");
	
	}

	@Test
	void testGetBook() {
		Book=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		int idBook=Book.getId();
		when(BookInterface.getBook(idBook)).thenReturn(Book);
		assertEquals(Book,BookInterface.getBook(idBook) ,"Book différent");
	}

	@Test
	void testAddBook() {
		Book=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		BookInterface.addBook(Book);
		verify(BookInterface,times(1)).addBook(Book);
	}
	@Test
	void testUpdateBook() {
		Book=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		BookInterface.updateBook(Book);
		verify(BookInterface,times(1)).updateBook(Book);
	}
	@Test
	void testDeleteBook() {
		Book=new Book(1,10001,"aaa","eee","2020-01-12","aa",1500);
		int idBook=Book.getId();
		BookInterface.deleteBook(idBook);
		verify(BookInterface,times(1)).deleteBook(idBook);
	}

}
