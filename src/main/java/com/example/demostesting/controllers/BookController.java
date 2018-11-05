package com.example.demostesting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demostesting.model.Authors;
import com.example.demostesting.model.Books;
import com.example.demostesting.services.AuthorService;
import com.example.demostesting.services.BookService;

@Controller
public class BookController {

	private BookService bookService;
	private AuthorService authorService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	 @RequestMapping(value = "/books", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("books", bookService.listAllBooks());
	        return "books";
	    }
	 
	  @RequestMapping("book/delete/{id}")
	    public String deleteBook(@PathVariable Long id){
		  bookService.deleteBook(id);
	        return "redirect:/books";
	    }
	  
	  @RequestMapping("book/{id}")
	    public String showBook(@PathVariable Long id, Model model){
		  bookService.getBookById(id).ifPresent(o -> model.addAttribute("book", o));
	      //  model.addAttribute("author", authorService.getAuthorById(id));
	        return "bookshow";
	    }
	  
	  @RequestMapping("book/new")
	    public String newProduct(Model model){
		 model.addAttribute("authors", authorService.listAllAuthors());
	        model.addAttribute("book", new Books());
	        return "bookform";
	    }
	  @RequestMapping(value = "book", method = RequestMethod.POST)
	    public String saveBook(Books book, Authors author){
		  authorService.saveAuthor(author);
		  bookService.saveBook(book);
	        return "redirect:/book/" + book.getId();
	    }
	  
	  @RequestMapping("book/edit/{id}")
	    public String edit(@PathVariable Long id, Model model){
	        model.addAttribute("book", bookService.getBookById(id));
	        return "bookform";
	    }
}
