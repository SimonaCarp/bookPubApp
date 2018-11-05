package com.example.demostesting.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demostesting.model.Books;

public interface BookService {
	
 Iterable<Books> listAllBooks();
 Optional<Books> getBookById(Long id);
 Books saveBook(Books book);
 void deleteBook(Long id);
 Iterable<Books> findAllBooksByAuthorName(String lastName);
 Collection<Books> findAllBooksByAuthorId(Long authorId);
 Books updateBook(Long id,Books newBook);
 void deleteAllBooksByAuthorId(Long authorId);
}
