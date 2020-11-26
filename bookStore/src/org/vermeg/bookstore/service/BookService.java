package org.vermeg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.bookstore.dao.BookDAO;
import org.vermeg.bookstore.interfaces.BookInterface;
import org.vermeg.bookstore.model.Book;

@Service("BookService")
public class BookService {
	
	@Autowired
	BookInterface livreInterface;
	
	@Transactional
	public List<Book> getAllBooks() {
		return BookInterface.getAllBooks();
	}

	@Transactional
	public Book getBook(int id) {
		return livreInterface.getBook(id);
	}

	@Transactional
	public void addBook(Book livre) {
		livreInterface.addBook(livre);
	}

	@Transactional
	public void updateBook(Book livre) {
		livreInterface.updateBook(livre);

	}

	@Transactional
	public void deleteBook(int id) {
		livreInterface.deleteBook(id);
	}

}
