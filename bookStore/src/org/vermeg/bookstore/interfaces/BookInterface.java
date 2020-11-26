package org.vermeg.bookstore.interfaces;

import java.util.List;

import org.vermeg.bookstore.model.Book;

public interface BookInterface {
	
	public static List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Book getBook(int id);
	
	public Book addBook(Book b);
	
	public void updateBook(Book b);
	
	public void deleteBook(int id);

	

}
