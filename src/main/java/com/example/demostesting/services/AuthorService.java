package com.example.demostesting.services;

import java.util.Collection;
import java.util.Optional;



import com.example.demostesting.model.Authors;
import com.example.demostesting.model.Books;

public interface AuthorService {
	 Iterable<Authors> listAllAuthors();

	 Optional<Authors> getAuthorById(Long id);

	    Authors saveAuthor(Authors author);

	    void deleteAuthor(Long id);
	 
	   
}
