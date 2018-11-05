package com.example.demostesting.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demostesting.model.Books;



public interface BookRepository extends CrudRepository<Books, Long>{
	@Modifying
	@Query(value = "select * from books b, authors a where  a.id = b.author_id and a.last_name= ?",  nativeQuery = true)
			Collection<Books> findAllBooksByAuthorName(String lastName);
	
	@Modifying
	@Query(value = "select * from books where author_id= ?",  nativeQuery = true)
	Collection<Books> findAllBooksByAuthorId(Long authorId);
	
	@Modifying
	@Query(value = "delete * from books where author_id= ?",  nativeQuery = true)
	void deleteAllBooksByAuthorId(Long authorId);
}
