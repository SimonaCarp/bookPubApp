package com.example.demostesting.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Authors {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstName;
	private String lastName;
	
	/*@OneToMany(mappedBy="author")
	List <Book> books;*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
/*	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}*/
	
	
}
