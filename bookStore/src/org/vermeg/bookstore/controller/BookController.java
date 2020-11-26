package org.vermeg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.bookstore.model.Book;
import org.vermeg.bookstore.service.BookService;

@RestController
@RequestMapping("/api/Book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(){
        return "Hello";
    }
	
	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getBooks() {
		
		List<Book> listOfBooks = bookService.getAllBooks();
		
		return listOfBooks;
	}

	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addLivre(@ModelAttribute("livre") Book livre) {	
		if(livre.getId()==0)
		{
			bookService.addBook(livre);
		}
		else
		{	
			bookService.updateBook(livre);
		}
		
		return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateLivre(@PathVariable("id") int id,@ModelAttribute("livre") Book livre,Model model) {
		if(bookService.getBook(id)==null)
		{
			System.out.print( "Book not found");
		}
		else
		{
			bookService.updateBook(livre);
			System.out.print( "done");
		}
		return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteLivre(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		 return "redirect:/getAllBooks";

	}	

}


