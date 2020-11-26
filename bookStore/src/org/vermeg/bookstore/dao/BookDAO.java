package org.vermeg.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vermeg.bookstore.interfaces.BookInterface;
import org.vermeg.bookstore.model.Book;

@Repository
public class BookDAO implements BookInterface{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Book> getAllBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> BookList = session.createQuery("from Book").list();
		
		for (Book l:BookList) {
			System.out.println(l.toString());
		}
		
		return BookList;
	}

	public Book getBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.get(Book.class, new Integer(id));
		return b;
	}

	public Book addBook(Book livre) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(livre);
		return livre;
	}

	public void updateBook(Book livre) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(livre);
	}

	public void deleteBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book l = (Book) session.load(Book.class, new Integer(id));
		if (null != l) {
			session.delete(l);
		}
	}	
}
