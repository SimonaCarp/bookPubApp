package com.example.demostesting.controllers;

import java.util.Collection;
import java.util.List;

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
public class AuthorController {

	private AuthorService authorService;
	private BookService bookService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	@Autowired
	public void setAuthorService (AuthorService authorService) {
		this.authorService = authorService;
	}
	
	 @RequestMapping(value = "/authors", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("authors", authorService.listAllAuthors());
	        return "authors";
	    }
	 
	 // delete inainte din DB pt carti? dar eventual de intrebat daca suntem siguri ca vrem asta si apoi sa stergem
	  @RequestMapping("author/delete/{id}")
	    public String delete(@PathVariable Long id){
		Collection<Books> booksByAuthorId = bookService.findAllBooksByAuthorId(id);
		if(booksByAuthorId.size()> 0) {
			bookService.deleteAllBooksByAuthorId(id);
			authorService.deleteAuthor(id);
			  return "redirect:/authors";
			//return "error";
		} else {
	        authorService.deleteAuthor(id);
	        return "redirect:/authors";
		}
	    }
	  
	  @RequestMapping("author/{id}")
	    public String showAuthor(@PathVariable Long id, Model model){
		  authorService.getAuthorById(id).ifPresent(o -> model.addAttribute("author", o));
	      //  model.addAttribute("author", authorService.getAuthorById(id));
	        return "authorshow";
	    }
	  
	  @RequestMapping("author/new")
	    public String newProduct(Model model){
	        model.addAttribute("author", new Authors());
	        return "authorform";
	    }
	  @RequestMapping(value = "author", method = RequestMethod.POST)
	    public String saveAuthor(Authors author){
	        authorService.saveAuthor(author);
	        return "redirect:/author/" + author.getId();
	    }
	  
	  @RequestMapping("author/edit/{id}")
	    public String edit(@PathVariable Long id, Model model){
	        model.addAttribute("author", authorService.getAuthorById(id));
	        return "authorform";
	    }
}
