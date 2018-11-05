package com.example.demostesting.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demostesting.model.Books;
import com.example.demostesting.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Books> listAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Optional<Books> getBookById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public Books saveBook(Books book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public Iterable<Books> findAllBooksByAuthorName(String lastName) {
		// TODO Auto-generated method stub
		
		return bookRepository.findAllBooksByAuthorName(lastName);
	}

	@Override
	public Books updateBook(Long id, Books newBook) {
	bookRepository.deleteById(id);
	bookRepository.save(newBook);
		return newBook;
	}
	@Override
	public Collection<Books> findAllBooksByAuthorId(Long authorId) {
		return bookRepository.findAllBooksByAuthorId(authorId);
	}
	@Override
	public void deleteAllBooksByAuthorId(Long authorId) {
		bookRepository.deleteAllBooksByAuthorId(authorId);
		
	}
}
