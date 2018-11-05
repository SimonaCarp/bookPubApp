package com.example.demostesting.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demostesting.model.Authors;
import com.example.demostesting.model.Books;
import com.example.demostesting.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{


	private AuthorRepository authorRepository;
	
	@Autowired
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	@Override
	public Iterable<Authors> listAllAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public Optional<Authors> getAuthorById(Long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}

	@Override
	public Authors saveAuthor(Authors author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}
	
	

}
