package com.example.demostesting.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demostesting.model.Authors;
import com.example.demostesting.model.Books;

public interface AuthorRepository extends CrudRepository<Authors, Long>{
	
}
